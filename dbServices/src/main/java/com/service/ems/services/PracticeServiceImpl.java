package com.service.ems.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ems.domain.Practice;
import com.service.ems.modelMappers.ModelMapperUtil;
import com.service.ems.models.AppointmentSearchModel;
import com.service.ems.models.PracticeModel;
import com.service.ems.repositories.PracticeRepository;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

@Service
@Transactional
public class PracticeServiceImpl implements PracticeService {

	@Autowired
	PracticeRepository practiceRepository;

	@PersistenceContext
	EntityManager em;

	@Override
	public List<PracticeModel> getAllPractice() {
		// ModelMapper modelMapper = ModelMapperUtil.getPracticeMapper();
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		List<PracticeModel> practicesModel;
		List<Practice> practices = practiceRepository.findAll();
		practicesModel = practices.stream().map(practice -> {
			return modelMapper.map(practice, PracticeModel.class);
		}).collect(Collectors.toList());
		return practicesModel;
	}

	@Override
	public List<PracticeModel> getPracticeById(long id) {
		// ModelMapper modelMapper = ModelMapperUtil.getPracticeMapper();
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		List<PracticeModel> practicesModel;
		List<Practice> practices = practiceRepository.findAllById(id);
		practicesModel = practices.stream().map(practice -> {
			return modelMapper.map(practice, PracticeModel.class);
		}).collect(Collectors.toList());
		return practicesModel;
	}

	@Override
	public PracticeModel addPractice(PracticeModel practicemodel) {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();

		StringBuilder wktPoint = new StringBuilder();
		wktPoint.append("POINT(");
		wktPoint.append(practicemodel.getLon());
		wktPoint.append(" ");
		wktPoint.append(practicemodel.getLat());
		wktPoint.append(")");
		// = "POINT(-71.118961 42.373570)";
		Geometry geom = wktToGeometry(wktPoint.toString());
		geom.setSRID(4326);
		practicemodel.setGeom((Point) geom);

		Practice practice = modelMapper.map(practicemodel, Practice.class);
		PracticeModel practiceModel = modelMapper.map(practiceRepository.saveAndFlush(practice), PracticeModel.class);
		return practiceModel;
	}

	@Override
	public PracticeModel updatePractice(PracticeModel practicemodel) {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		Practice practice = modelMapper.map(practicemodel, Practice.class);
		PracticeModel practiceModel = modelMapper.map(practiceRepository.saveAndFlush(practice), PracticeModel.class);
		return practiceModel;
	}

	@Override
	public void deletePractice(long id) {
		List<PracticeModel> practice = getPracticeById(id);
		practice.get(0).setInactive(true);
		updatePractice(practice.get(0));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Practice> getSearchAppointment(AppointmentSearchModel appointmentSearchModel) {
		/**/String str = "SELECT * FROM practice p " + "LEFT JOIN doctor d ON p.id = d.practice_id "
				+ "LEFT JOIN doctor_schedule ds ON d.id = ds.doctor_id ";
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append(str);
		queryBuilder.append(" where ST_DWithin(p.geom, ST_MakePoint(");
		queryBuilder.append(appointmentSearchModel.getLon());
		queryBuilder.append(",");
		queryBuilder.append(appointmentSearchModel.getLat());
		queryBuilder.append(")\\:\\:geography, ");
		queryBuilder.append(appointmentSearchModel.getRadius());
		queryBuilder.append(") ");

		if (!StringUtils.isBlank(appointmentSearchModel.getStartDate())
				&& !StringUtils.isBlank(appointmentSearchModel.getEndDate())) {
			queryBuilder.append("AND ds.schedule_date >= '");
			queryBuilder.append(appointmentSearchModel.getStartDate());
			queryBuilder.append("'\\:\\:DATE AND ds.schedule_date <= '");
			queryBuilder.append(appointmentSearchModel.getEndDate());
			queryBuilder.append("'\\:\\:DATE ");
		}

		if(!StringUtils.isBlank(appointmentSearchModel.getWeekDay())) {
			queryBuilder.append("AND trim(to_char(ds.schedule_date, 'DAY')) = '");
			queryBuilder.append(appointmentSearchModel.getWeekDay());
			queryBuilder.append("'");
		}
		

		System.out.println("queryBuilder is " + queryBuilder.toString());

		List<Practice> practiceList = new ArrayList<Practice>();		/**/
		practiceList = em.createNativeQuery(queryBuilder.toString(), Practice.class).getResultList();


		return practiceList;
	}

	private Geometry makeGeom(double lon, double lat) {
		StringBuilder wktPoint = new StringBuilder();
		wktPoint.append("POINT(");
		wktPoint.append(lon);
		wktPoint.append(" ");
		wktPoint.append(lat);
		wktPoint.append(")");
		Geometry geom = wktToGeometry(wktPoint.toString());
		geom.setSRID(4326);
		return geom;
	}

	private Geometry wktToGeometry(String wktPoint) {
		WKTReader fromText = new WKTReader();
		Geometry geom = null;
		try {
			geom = fromText.read(wktPoint);
		} catch (ParseException e) {
			throw new RuntimeException("Not a WKT string:" + wktPoint);
		}
		return geom;
	}
}
