package com.psl.lithium.FreeMarkerHelloo;

import java.util.List;

import freemarker.template.SimpleNumber;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

@SuppressWarnings("deprecation")
public class IndexOfMethod implements TemplateMethodModel {

	public TemplateModel exec(@SuppressWarnings("rawtypes") List args)
			throws TemplateModelException {
		if (args.size() != 2) {
			throw new TemplateModelException("Wrong arguments");
		}
		return new SimpleNumber(((String) args.get(1)).indexOf((String) args
				.get(0)));
	}
}