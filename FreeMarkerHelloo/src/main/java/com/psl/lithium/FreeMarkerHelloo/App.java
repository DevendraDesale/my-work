package com.psl.lithium.FreeMarkerHelloo;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

/**
 * @author devendra_desale
 * Hello Freemarker! This is the first free marker code
 * 
 */
public class App {

	private static Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		LOGGER.info("Entering the main method");

		// FreeMarker configuration object
		Configuration cfg = new Configuration();

		// Specify the data source where the template files come from. Here I
		// set a
		// plain directory for it, but non-file-system are possible too:
		try {
			cfg.setDirectoryForTemplateLoading(new File(
					"src/main/resources/templates"));
		} catch (IOException e1) {
			// LOGGER.warn(e1);
			e1.printStackTrace();
		}

		// Specify how templates will see the data-model. This is an advanced
		// topic...
		// for now just use this:
		cfg.setObjectWrapper(new DefaultObjectWrapper());

		// Set your preferred charset template files are stored in. UTF-8 is
		// a good choice in most applications:
		cfg.setDefaultEncoding("UTF-8");

		// Sets how errors will appear. Here we assume we are developing HTML
		// pages.
		// For production systems TemplateExceptionHandler.RETHROW_HANDLER is
		// better.
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);

		// At least in new projects, specify that you want the fixes that aren't
		// 100% backward compatible too (these are very low-risk changes as far
		// as the 1st and 2nd version number remains):
		cfg.setIncompatibleImprovements(new Version(2, 3, 20)); // FreeMarker
																// 2.3.20
		try {
			// Load template from source folder
			Template template = cfg.getTemplate("helloworld.ftl");

			// Build the data-model
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("message", "Hello World!");

			// Date could be directly put into template.
			Date date = new Date();
			System.out.println(date);
			data.put("date1", date);

			// You can set maps.
			Map<String, Integer> myHash = new HashMap<String, Integer>();

			myHash.put("first", 1);
			myHash.put("second", 2);

			data.put("hash", myHash);

			// List parsing.
			List<String> countries = new ArrayList<String>();
			countries.add("India");
			countries.add("United States");
			countries.add("Germany");
			countries.add("France");

			data.put("countries", countries);

			data.put("indexOf", new IndexOfMethod());

			data.put("upper", new UpperDirective());

			data.put("doc", freemarker.ext.dom.NodeModel.parse(new File(
					"src/main/resources/myXml.xml")));

			// Console output
			Writer out = new OutputStreamWriter(System.out);
			template.process(data, out);
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}
