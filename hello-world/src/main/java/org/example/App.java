package org.example;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.configuration.JobRunrConfiguration;
import org.jobrunr.jobs.JobId;
import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.storage.InMemoryStorageProvider;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.utils.mapper.JsonMapper;
import org.jobrunr.utils.mapper.gson.GsonJsonMapper;
import org.jobrunr.utils.mapper.jsonb.JsonbJsonMapper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        InMemoryStorageProvider inMemoryStorageProvider = new InMemoryStorageProvider();
        inMemoryStorageProvider.setJobMapper(new JobMapper(new GsonJsonMapper()));
        JobRunr.configure().useStorageProvider(inMemoryStorageProvider).useBackgroundJobServer().initialize();
        JobId enqueue = BackgroundJob.enqueue(() -> System.out.println("Hello World"));
        System.out.println(enqueue);
        try {
            int read = System.in.read();
        } catch (IOException e) {
           e.printStackTrace();
        }


    }
}
