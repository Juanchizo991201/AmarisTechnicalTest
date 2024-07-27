# Amaris Technical Assesment

## Description

Build a Java MVC app using good design practices. Consume REST APIs, perform calculations, and display data in a user-friendly interface. Use a Java IDE, version control, and unit testing. Deploy to a server.

## Requirements

Make sure you have installed on your system:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Java JDK](https://www.oracle.com/co/java/technologies/downloads/#java17) (para el backend)
- [Node.js y npm](https://nodejs.org/en/) (para el frontend)

## Starting

Sigue estas instrucciones para configurar y ejecutar el proyecto en tu máquina local.

### Clone the repository

```bash
git clone https://github.com/Juanchizo991201/AmarisTechnicalTest.git
cd tu-AmarisTechnicalTest
```

### Build and execute

To build and run the project, use the following command:

```bash
docker compose up --build
```

### Access the Application

Once the project is running, you can access it at: [http://localhost:80](http://localhost:80/)

### Projrct structure

The project is divided into frontend and backend components. Both are configured for Docker containerization.

**Backend**
- **Build system**: Gradle is used for building the backend application.
- **Containerization**: Dockerfile provides instructions to create a Docker image for the backend.
- **Structure**:
  - `src`: Contains the main application code.
  - `build`: Stores compiled artifacts.
  - `bin`: Likely holds executable files.
  - `gradle`: Gradle-related files (optional).

**Frontend**
- **Build system**: npm or yarn is used for managing dependencies and building the frontend application.
- **Containerization**: Dockerfile provides instructions to create a Docker image for the frontend.
- **Structure**:
  - `src`: Contains the main application code (likely TypeScript).
  - `public`: Holds static assets.
  - `dist`: Stores the production-ready build.
  - `node_modules`: Contains installed dependencies.

**Additional Notes**
`docker-compose.yml`: Defines how to run both frontend and backend containers together.
`README.md` files provide project documentation at both the root and individual component levels.

```bash
.
├── backend
│   ├── bin
│   ├── build
│   ├── build.gradle
│   ├── Dockerfile
│   ├── gradle
│   ├── gradlew
│   ├── gradlew.bat
│   ├── HELP.md
│   ├── settings.gradle
│   └── src
├── docker-compose.yml
├── frontend
│   ├── dist
│   ├── Dockerfile
│   ├── index.html
│   ├── node_modules
│   ├── package.json
│   ├── package-lock.json
│   ├── public
│   ├── README.md
│   ├── src
│   ├── tsconfig.app.json
│   ├── tsconfig.json
│   ├── tsconfig.node.json
│   └── vite.config.ts
└── README.md
```

> [!NOTE]
> If you want to start the backend and the front end independently you must follow the following steps.



## Start frontend and backend independently

> [!IMPORTANT]
> Firstly, you must have had cloned the repository .

### To start the backend 

1. Clean and build the Gradle project with the following commands

```bash
cd backend
./gradlew clean build
```

2. Execute the war file
```bash
java -jar build/libs/AmarisTest-1.0.war
```

> [!NOTE]
> The backend will start in the [http://localhost:8080](http://localhost:8080).


### To start the frontend 

1. Build with the following commands

```bash
cd frontend
npm install
npm run build
```

2. Execute the application
```bash
npm run preview
```

> [!NOTE]
> The frontend will start in the [http://localhost:4173/](http://localhost:4173/).
