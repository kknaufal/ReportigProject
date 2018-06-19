package com.service.ems.firebase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHandler {
	private static DatabaseReference database;

	public static void initializeFirebase(String databaseUrl) {
		try {

			FileInputStream serviceAccount = new FileInputStream(
					"src\\main\\resources\\emsdas-12a16-firebase-adminsdk-mw9iy-84e579072a.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl(databaseUrl).build();
			FirebaseApp.initializeApp(options);
			System.out.println("Initialized Firebase successfully");
			;
			// [END initialize]
		} catch (IOException e) {
			System.out.println("ERROR: invalid service account credentials. See README...");
			System.out.println(e.getMessage());

			System.exit(1);
		}
		database = FirebaseDatabase.getInstance().getReference();

	}

	public static void insertNotifications(Map<String, Object> notificaitons) {

		database.updateChildrenAsync(notificaitons);

	}

}
