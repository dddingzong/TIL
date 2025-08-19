# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Korean TIL (Today I Learned) repository focused on documenting learning progress in software engineering, particularly Spring Framework and Java concepts. The project serves as both a knowledge base and practical code examples repository.

## Commands

### Build & Development
```bash
# Build the project
./gradlew build

# Clean build artifacts
./gradlew clean

# Run tests
./gradlew test

# Run main application
./gradlew bootRun

# View available tasks
./gradlew tasks
```

**Note**: The build.gradle.kts has an incomplete dependency on line 22 (`implementation("org.springframework.boot:spring-boot-")`) that needs to be fixed before building.

### Development Workflow
- Code examples are in `src/main/java/`
- Theory documentation is in `theory/` directory
- Supporting images are in `image/` directory

## Architecture & Structure

### Core Organization
- **Theory Documentation** (`theory/`): Markdown files explaining concepts like AOP, IoC, DI, Spring Framework, TDD, etc.
- **Code Examples** (`src/main/java/`): Practical implementations demonstrating the theoretical concepts
- **Image Assets** (`image/`): Visual diagrams and screenshots supporting the documentation

### Spring Framework Focus
The repository centers around Spring ecosystem learning:
- **Spring Core**: IoC, DI, AOP concepts with detailed explanations
- **Spring Boot**: Project structure follows Spring Boot 3.2.5 conventions
- **Architecture Patterns**: Examples include enum usage, builder pattern, and controller advice

### Documentation Structure
Each theory file follows this pattern:
- Korean introduction explaining motivation for learning the topic
- Detailed technical explanation with examples
- Supporting code in corresponding Java packages
- Visual diagrams in the `image/` subdirectory

### Key Learning Topics Covered
- Spring Framework fundamentals (IoC, DI, AOP, PSA)
- Java language features (enums, builder pattern)
- Testing concepts (TDD, mock objects)
- Development tools (GitHub Copilot)
- Infrastructure concepts (DevOps, reverse proxy)
- Performance concepts (synchronous/asynchronous, blocking/non-blocking)

## Dependencies & Technology Stack
- **Java 17**: Target JVM version
- **Spring Boot 3.2.5**: Main application framework
- **Gradle 8.8**: Build system with Kotlin DSL
- **JUnit 5**: Testing framework
- **Lombok**: Code generation (compilation time)
- **Spring Data JPA**: Data persistence layer
- **Spring AOP**: Aspect-oriented programming support

## Development Context
This is a personal learning repository where:
- Each markdown file represents a day's learning on a specific topic
- Code examples demonstrate practical application of theoretical concepts
- Korean comments and documentation reflect the learning process
- Images provide visual understanding of complex concepts