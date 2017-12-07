package quizMiniGame;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionAndAnswerPairsReader.
 */
public class QuestionAndAnswerPairsReader implements Serializable {
	
	/**
	 * Gets the question and answer pairs.
	 *
	 * @return the question and answer pairs
	 */
	public ArrayList<QuestionAndAnswerPair> getQuestionAndAnswerPairs() {
		
		
		Document document = this.getQuestionAndAnswerPairsDocumentFromXML();
		document.getDocumentElement().normalize();
		NodeList nodeList = document.getElementsByTagName("QuestionAndAnswer");
		
		ArrayList<QuestionAndAnswerPair> questionAndAnswerPairs = new ArrayList<QuestionAndAnswerPair>();
		for (int currentNodeIndex = 0; currentNodeIndex < nodeList.getLength(); currentNodeIndex++) {
			Node nodeAtCurrentIndex = nodeList.item(currentNodeIndex);

			if (nodeAtCurrentIndex.getNodeType() == Node.ELEMENT_NODE) {
				Element elementNodeAtCurrentIndex = (Element) nodeAtCurrentIndex;

				//easy
				//get two true or false q's
				
				//med
				//get two anything q's
				
				
				//hard
				questionAndAnswerPairs.add(new QuestionAndAnswerPair(elementNodeAtCurrentIndex.getElementsByTagName("Question").item(0).getTextContent(),
										elementNodeAtCurrentIndex.getElementsByTagName("answerA").item(0).getTextContent(),
										elementNodeAtCurrentIndex.getElementsByTagName("answerB").item(0).getTextContent(),
										elementNodeAtCurrentIndex.getElementsByTagName("answerC").item(0).getTextContent(),
										elementNodeAtCurrentIndex.getElementsByTagName("correctAnswer").item(0).getTextContent()));
			}
		}
		return questionAndAnswerPairs;
	}
	
	/**
	 * Gets the question and answer pairs document from XML.
	 *
	 * @return the question and answer pairs document from XML
	 */
	public Document getQuestionAndAnswerPairsDocumentFromXML() {
		try {

			File questionAndAnswerPairsFile = new File("miniGameQuestionAndAnswerPairs.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(questionAndAnswerPairsFile);

			return document;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
