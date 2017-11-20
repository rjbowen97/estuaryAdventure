package quizMiniGame;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class MiniGameMain {

	public static void main(String[] args) {
		try {

			File questionsAndAnswersFile = new File("miniGameQuestionsAndAnswers.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(questionsAndAnswersFile);

			document.getDocumentElement().normalize();

			System.out.println("Root element : " + document.getDocumentElement().getNodeName());

			NodeList nodeList = document.getElementsByTagName("QuestionAndAnswer");

			System.out.println("");

			for (int currentItemIndex = 0; currentItemIndex < nodeList.getLength(); currentItemIndex++) {

				Node nodeAtCurrentItemIndex = nodeList.item(currentItemIndex);

				System.out.println("Current Element : " + nodeAtCurrentItemIndex.getNodeName());

				if (nodeAtCurrentItemIndex.getNodeType() == Node.ELEMENT_NODE) {

					Element elementNodeAtCurrentIndex = (Element) nodeAtCurrentItemIndex;

					System.out.println("QuestionAndAnswer id : " + elementNodeAtCurrentIndex.getAttribute("ID"));
					System.out.println("Question : " + elementNodeAtCurrentIndex.getElementsByTagName("Question").item(0).getTextContent());
					System.out.println("Answer : " + elementNodeAtCurrentIndex.getElementsByTagName("Answer").item(0).getTextContent());
				}
				System.out.println("----------------");
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
	}

}
