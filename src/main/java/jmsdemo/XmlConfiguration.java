package jmsdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"camel*.xml"})
public class XmlConfiguration {

}
