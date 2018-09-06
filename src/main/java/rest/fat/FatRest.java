package rest.fat;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import rest.fat.api.HelloResource;

public class FatRest {

    public static void main(String... args) throws Exception {

        Swarm swarm = new Swarm();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.addClass(HelloResource.class);

        deployment.addClass(FatRestApplication.class);
        deployment.addAllDependencies();
        swarm.start().deploy(deployment);

    }
}
