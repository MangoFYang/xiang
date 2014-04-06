package com.yangfan.xiang.test.schema;

import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class ValidateXML {

	public boolean Validatexml(String[] xsdpath, String xmlpath)
			throws SAXException, IOException {
		// 建立schema工厂
		SchemaFactory schemaFactory = SchemaFactory
				.newInstance("http://www.w3.org/2001/XMLSchema");
		// 建立验证文档文件对象，利用此文件对象所封装的文件进行schema验证
		Source[] schemaSource = new StreamSource[xsdpath.length];
		for (int i = 0; i < xsdpath.length; i++) {
			Source source = new StreamSource(xsdpath[i]);
			schemaSource[i] = source;
		}
		// 利用schema工厂，接收验证文档文件对象生成Schema对象
		Schema schema = schemaFactory.newSchema(schemaSource);
		// 通过Schema产生针对于此Schema的验证器，利用schenaFile进行验证
		Validator validator = schema.newValidator();
		// 得到验证的数据源
		Source source = new StreamSource(xmlpath);
		// 开始验证，成功输出success!!!，失败输出fail
		validator.validate(source);
		return true;
	}

	public static void main(String[] args) {

		String path = "D:/Program Files/sts/sts-3.4.0.RELEASE/workspace-sts-3.4.0.RELEASE/XMLExamples/My";

		ValidateXML v = new ValidateXML();
		try {
			boolean validatexml = v.Validatexml(new String[] {
					path + "/Books.xsd", path + "/test.xsd" }, path
					+ "/Books.xml");
			System.out.println(validatexml);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}
