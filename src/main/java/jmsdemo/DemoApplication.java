package jmsdemo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private static final Class[] parameters = new Class[] { URL.class };

	public static void main(String[] args) throws IOException {

//		 File f = new File(".");
//		 URL url = f.toURI().toURL();
//		 URLClassLoader sysloader = (URLClassLoader)
//		 ClassLoader.getSystemClassLoader();
//		 Class sysclass = URLClassLoader.class;
//		
//		 try {
//		 Method method = sysclass.getDeclaredMethod("addURL", parameters);
//		 method.setAccessible(true);
//		 method.invoke(sysloader, new Object[] { url });
//		
//		 System.out.println("System classloader:");
//		 //sysloader.getURLs()
//		 for (URL u : sysloader.getURLs()) {
//			 System.out.println(u);
//		 }
//		// Class aClass = sysloader.loadClass("MyProcessor");
//		// System.out.println("Loaded " + aClass);
//		 } catch (Throwable t) {
//		 t.printStackTrace();
//		 throw new IOException("Error, could not add URL to system classloader");
//		 } // end try catch
//
//		Class threadClass = Thread.class;
//		try {
//			Method method = threadClass.getDeclaredMethod("getContextClassLoader", new Class[] {});
//			method.setAccessible(true);
//			URLClassLoader classLoader = (URLClassLoader) method.invoke(Thread.currentThread(), new Object[] {});
//			
//
//			 System.out.println("Got " + classLoader);
//			 method = URLClassLoader.class.getDeclaredMethod("addURL", parameters);
//			 method.setAccessible(true);
//			 method.invoke(classLoader, new Object[] { url });
//			 System.out.println("Spring classloader:");
//			 for (URL u : classLoader.getURLs()) {
//				 System.out.println(u);
//			 }
//			 Class aClass = classLoader.loadClass("MyProcessor", true);
//			 System.out.println("Loaded " + aClass);
//			
//		} catch (Throwable t) {
//			t.printStackTrace();
//			throw new IOException("Error, could not add URL to Spring's classloader");
//		}
		SpringApplication.run(DemoApplication.class, args);
	}

}
