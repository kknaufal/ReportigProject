package com.iso.poreport.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "acs_rels")
@NamedQuery(name = "AcsRels.findEmployeesFromProject",
		/*
		 * query = "select rel.*, biz.percentage,usr.* from acs_rels rel" +
		 * " join im_biz_object_members biz on rel.rel_id = biz.rel_id" +
		 * " join users usr on usr.user_id = rel.object_id_two where object_id_one =:projectId"
		 * )
		 */
		// .relId, rel.objectIdOne, rel.objectIdTwo, biz.percentage, usr.username
		/*
		 * query="select rel" + " from AcsRels rel join rel.bizObjectMembers biz" +
		 * " join rel.users usr" +
		 * " where rel.objectIdOne =:projectId and biz.percentage is NOT null and biz.percentage > 0"
		 * ) Integer relId, String relType, Integer objectIdOne, Integer objectIdTwo,
		 * imBizObjectMembers bizObjectMembers, Users users, ImProjects imProjects
		 */
		query = "select new AcsRels(rel.relId, rel.objectIdOne, rel.objectIdTwo, usr.username, pro.projectName) "
				+ " from AcsRels rel" + " join rel.bizObjectMembers biz" + " join rel.users usr"
				+ " join rel.imProjects pro"
				+ " where rel.objectIdOne =:projectId and biz.percentage is NOT null and biz.percentage > 0")
public class AcsRels {
	@Id
	@GeneratedValue
	@Column(name = "rel_id")
	private Integer relId;
	@Column(name = "rel_type")
	private String relType;
	@Column(name = "object_id_one")
	private Integer objectIdOne;
	@Column(name = "object_id_two")
	private Integer objectIdTwo;
	@OneToOne
	@JoinColumn(name = "rel_id")
	private imBizObjectMembers bizObjectMembers;
	@OneToOne
	@JoinColumn(name = "object_id_two", insertable = false, updatable = false)
	private Users users;
	@OneToOne
	@JoinColumn(name = "object_id_one", insertable = false, updatable = false)
	private ImProjects imProjects;

	public imBizObjectMembers getBizObjectMembers() {
		return bizObjectMembers;
	}

	public void setBizObjectMembers(imBizObjectMembers bizObjectMembers) {
		this.bizObjectMembers = bizObjectMembers;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getRelId() {
		return relId;
	}

	public void setRelId(Integer relId) {
		this.relId = relId;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public Integer getObjectIdOne() {
		return objectIdOne;
	}

	public void setObjectIdOne(Integer objectIdOne) {
		this.objectIdOne = objectIdOne;
	}

	public Integer getObjectIdTwo() {
		return objectIdTwo;
	}

	public void setObjectIdTwo(Integer objectIdTwo) {
		this.objectIdTwo = objectIdTwo;
	}

	public ImProjects getImProjects() {
		return imProjects;
	}

	public void setImProjects(ImProjects imProjects) {
		this.imProjects = imProjects;
	}

	public AcsRels() {
		super();
	}

	public AcsRels(Integer relId, Integer objectIdOne, Integer objectIdTwo, String userName, String projectName) {
		super();
		this.relId = relId;
		this.objectIdOne = objectIdOne;
		this.objectIdTwo = objectIdTwo;
		this.users = new Users() {
			{
				setUserId(objectIdTwo);
				setUsername(userName);
			}
		};
		this.imProjects = new ImProjects() {
			{
				setProjectId(objectIdOne);
				setProjectName(projectName);
			}
		};
	}

	@Override
	public String toString() {
		return "AcsRels [relId=" + relId + ", relType=" + relType + ", objectIdOne=" + objectIdOne + ", objectIdTwo="
				+ objectIdTwo + ", bizObjectMembers=" + "bizObjectMembers" + ", users=" + "users" + "]";
	}

}
