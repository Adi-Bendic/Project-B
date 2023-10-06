package com.example.projectb;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {
        String result = null;

        try {
            // Create a URL object with the URL you want to request
            URL url = new URL(urls[0]);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set up the request method (GET, POST, etc.)
            connection.setRequestMethod("GET");

            // Set up any headers if needed
            // connection.setRequestProperty("HeaderName", "HeaderValue");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Check if the response code is OK (HTTP 200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response data
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                result = response.toString();
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        // Handle the response here
        if (result != null) {
            // Process the response data
            // You can update the UI or perform other actions here
        }
    }
}
