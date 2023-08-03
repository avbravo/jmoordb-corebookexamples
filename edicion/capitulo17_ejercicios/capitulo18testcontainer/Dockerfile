# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#FROM payara/micro:5.2021.1
FROM payara/micro:5.193

CMD ["--deploymentDir", "/opt/payara/deployments", "--noCluster"]

COPY target/capitulo18testcontainer.war $DEPLOY_DIR

# CMD ["--nocluster","--deploymentDir", "/opt/payara/deployments", "--contextroot", "capitulo20"]

#FROM payara/micro:5.193
#CMD ["--deploymentDir", "/opt/payara/deployments", "--noCluster"]
#ADD build/libs/myservice.war /opt/payara/deployments