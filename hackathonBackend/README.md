# Backend


### Requirements
1. Maven/Eclipse(spring tools extension installed)/Spring Tool Suite
2. Basic GCP knowledge as to how to create a service account

## Setup

1. Clone the repo

```
> git clone "url"
```
2. Create a cloudsql service account key in json format


3. Directing the spring-boot app towards the credentials

```
> If you have gcloud sdk installed, then create an environment variable with name "GOOGLE_APPLICATION_CREDENTIALS" and path "$PATH\cloudsql.json"
> If you do not have gcloud sdk installed, add the following line to the "application.properties" file (under src/main/resources)
   "spring.cloud.gcp.credentials.location=classpath:$PATH/cloudsql.json" (Use forward slash)
> If that does not work, you can even configure the variable during runtime through eclipse/spring tool suite by going into the "Run" menu, click on "Run configurations" then add a new environment variable with name "GOOGLE_APPLICATION_CREDENTIALS" and value (path) "$PATH\cloudsql.json"

```

## Run the application
1. Through spring-tool-suite or eclipse(with spring tools extension installed)

```
> Click on "File", "Import", then click on "Existing Maven Projects" and choose the directory where you have cloned the repo
> Right click on the root folder, choose Run as "Maven install" (if in case any of the dependencies weren't satisfied while importing, this makes sure and downloads the rest)
> Build must be successful and now right click on the root folder and Run as "Spring Boot App"
```

2. Through cmd(maven)

```
> Open command prompt at root folder and type the following commmands
> "mvn clean install"
> "mvn spring-boot:run"
```
You can configure the port if in case port 8080 is busy, just add the line "server.port=xxxx" to the "application.properties" file (replace "xxxx" with any four numbers)

## Using the application
Hit localhost:xxxx/swagger-ui.html to try endpoints

NOTE: LOGIN BEFORE GETTING TRANSACTION DATA