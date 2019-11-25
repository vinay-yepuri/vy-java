/**
 * 
 */
package org.vinay.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author VINAY
 *
 */
public class DrawingApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Triangle triangle = new Triangle();
		
		//@SuppressWarnings("deprecation")
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		
		Triangle triangle = (Triangle) context.getBean("triangle");
		
		triangle.draw();
		

	}

}
