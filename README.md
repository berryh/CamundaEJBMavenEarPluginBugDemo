## Camunda EJB Maven Ear Plugin Demo

This project attempts to show the difference between Maven EAR Plugin version `3.1.0` and `3.2.0` when working with Camunda and its EJB client library. The older version of the plugin causes the EJB client jar to be packaged with the `.war` file inside the `.ear`, which works properly. Camunda can find the workflow, events and services.

When trying this with the newer version of the EAR plugin (`3.2.0`), this doesn't work. The file still deploys, but Camunda does not find nor trigger the events (and services).

### Reproduction

#### Working Scenario

1. Build the project as-is using `mvn clean package`. The EAR plugin is set to version `3.1.0`.
2. Deploy to the WildFly distribution of Camunda, version `7.9.0`.
3. Start the workflow using a REST call and watch the log output, which outputs `This is a sample event!` for example.

#### Non-functional Scenario

1. Adjust the EAR plugin version to `3.2.0` and build using `mvn clean package`.
2. Deploy to the WildFly distribution of Camunda, version `7.9.0`.
3. Start the workflow using a REST call and watch the log output, nothing should be shown.