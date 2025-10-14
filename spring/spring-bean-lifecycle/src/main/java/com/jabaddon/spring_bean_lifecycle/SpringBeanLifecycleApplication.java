package com.jabaddon.spring_bean_lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBeanLifecycleApplication {

	public static void main(String[] args) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║  SPRING BEAN LIFECYCLE DEMONSTRATION   ║");
		System.out.println("╚════════════════════════════════════════╝\n");

		System.out.println("========================================");
		System.out.println("🚀 STARTING SPRING CONTEXT");
		System.out.println("========================================\n");

		// Start the Spring context
		ConfigurableApplicationContext context = SpringApplication.run(SpringBeanLifecycleApplication.class, args);

		System.out.println("\n========================================");
		System.out.println("✅ CONTEXT FULLY STARTED");
		System.out.println("========================================\n");

		// Demo 1: Bean lifecycle
		System.out.println("📌 DEMO 1: Bean Lifecycle Phases\n");
		MyBean myBean = context.getBean(MyBean.class);
		myBean.doSomething();

		// Note: Circular dependency demo runs automatically via @PostConstruct
		// See CircularDependencyDemo class

		System.out.println("\n========================================");
		System.out.println("🛑 CLOSING SPRING CONTEXT");
		System.out.println("========================================\n");

		// Close the context to see the destruction phase
		context.close();

		System.out.println("\n========================================");
		System.out.println("❌ CONTEXT CLOSED");
		System.out.println("========================================");
	}

}
