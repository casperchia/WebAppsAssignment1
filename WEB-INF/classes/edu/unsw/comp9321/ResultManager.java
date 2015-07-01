package edu.unsw.comp9321;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ResultManager {
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	Document doc;
	
	public ResultManager(InputSource xmlFile){
		try {
    		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder builder = builderFactory.newDocumentBuilder();
    		doc = builder.parse(xmlFile);
		}catch(Exception e){
			logger.severe(e.getMessage());
		}
	}

	public ArrayList<ResultBean> getResults(String searchInput) {
		ArrayList<ResultBean> results = new ArrayList<ResultBean>();
		NodeList resultNodes = doc.getElementsByTagName("dc");

		for(int i = 0; i < resultNodes.getLength(); i++){
			Node n = resultNodes.item(i);
			NodeList resultChildren = n.getChildNodes();
			ResultBean bean = new ResultBean();
			for(int j = 0; j < resultChildren.getLength(); j++){
				Node child = resultChildren.item(j);
				
	            if(child.getNodeName().equalsIgnoreCase("contributor")){
	                if(bean.getContributor().contentEquals("")){
	                   bean.setContributor(child.getTextContent());
	                }else{
	                   bean.setContributor(bean.getContributor() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("coverage")){
	                if(bean.getCoverage().contentEquals("")){
	                   bean.setCoverage(child.getTextContent());
	                }else{
	                   bean.setCoverage(bean.getCoverage() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("creator")){
	                if(bean.getCreator().contentEquals("")){
	                   bean.setCreator(child.getTextContent());
	                }else{
	                   bean.setCreator(bean.getCreator() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("date")){
	                if(bean.getDate().contentEquals("")){
	                   bean.setDate(child.getTextContent());
	                }else{
	                   bean.setDate(bean.getDate() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("description")){
	                if(bean.getDescription().contentEquals("")){
	                   bean.setDescription(child.getTextContent());
	                }else{
	                   bean.setDescription(bean.getDescription() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("format")){
	                if(bean.getFormat().contentEquals("")){
	                   bean.setFormat(child.getTextContent());
	                }else{
	                   bean.setFormat(bean.getFormat() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("identifier")){
	                if(bean.getIdentifier().contentEquals("")){
	                   bean.setIdentifier(child.getTextContent());
	                }else{
	                   bean.setIdentifier(bean.getIdentifier() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("language")){
	                if(bean.getLanguage().contentEquals("")){
	                   bean.setLanguage(child.getTextContent());
	                }else{
	                   bean.setLanguage(bean.getLanguage() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("publisher")){
	                if(bean.getPublisher().contentEquals("")){
	                   bean.setPublisher(child.getTextContent());
	                }else{
	                   bean.setPublisher(bean.getPublisher() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("relation")){
	                if(bean.getRelation().contentEquals("")){
	                   bean.setRelation(child.getTextContent());
	                }else{
	                   bean.setRelation(bean.getRelation() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("rights")){
	                if(bean.getRights().contentEquals("")){
	                   bean.setRights(child.getTextContent());
	                }else{
	                   bean.setRights(bean.getRights() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("source")){
	                if(bean.getSource().contentEquals("")){
	                   bean.setSource(child.getTextContent());
	                }else{
	                   bean.setSource(bean.getSource() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("subject")){
	                if(bean.getSubject().contentEquals("")){
	                   bean.setSubject(child.getTextContent());
	                }else{
	                   bean.setSubject(bean.getSubject() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("title")){
	                if(bean.getTitle().contentEquals("")){
	                   bean.setTitle(child.getTextContent());
	                }else{
	                   bean.setTitle(bean.getTitle() + ", " + child.getTextContent());
	                }
	             }
	             if(child.getNodeName().equalsIgnoreCase("type")){
	                if(bean.getType().contentEquals("")){
	                   bean.setType(child.getTextContent());
	                }else{
	                   bean.setType(bean.getType() + ", " + child.getTextContent());
	                }
	             }
			}

			if(bean.getSubject() != null){
				String regex = "[^a-zA-Z0-9_]" + searchInput + "[^a-zA-Z0-9_]";
				Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(bean.getSubject());
				if(matcher.find()){
					results.add(bean);
//					System.out.println(bean.getSubject());
				}
			}

		}
		
        // Set unique id for each dataset
        for(int i = 0; i < results.size(); i++){
        	results.get(i).setId(i);
        }
		return results;
	}
}












