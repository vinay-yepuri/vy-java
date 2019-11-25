/**
 * 
 */
package org.vinay.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

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
		
		@SuppressWarnings("deprecation")
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		
		Triangle triangle = (Triangle) beanFactory.getBean("triangle");
		
		triangle.draw();

	}

}
