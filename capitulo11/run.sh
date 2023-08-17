mvn clean install payara-micro:bundle

java -jar target/capitulo10-microbundle.jar 


 <option>
                                <key></key>
                                <value>Djdk.util.zip.disableZip64ExtraFieldValidation=true</value>
                            </option>

--domainConfig

--
commandoptions maven agrega el domain.xml

  <option>
                            <key>--domainconfig</key>
                            <value>src/main/resources/domain.xml</value>
                        </option>
