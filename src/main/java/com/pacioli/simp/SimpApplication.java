package com.pacioli.simp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class SimpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpApplication.class, args);
	}

	@Component
	class ShutdownListener implements ApplicationListener<ContextClosedEvent> {

		@Override
		public void onApplicationEvent(ContextClosedEvent event) {
			// Действия при закрытии приложения (например, очистка файла)
			clearFile();
		}

		private void clearFile() {
			try (
					FileOutputStream f = new FileOutputStream("/Users/alexandrzhidkov/Documents/УчебаJava/Курс/Spring/Lesson3/Hw3Mvc/WW2/simp/src/main/java/fileRep/data.txt");
			) {
				f.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
