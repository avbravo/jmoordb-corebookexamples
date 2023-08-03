
mvn clean package
mvn liberty:create liberty:install-feature
mvn liberty:configure-arquillian

mvn failsafe:integration-test