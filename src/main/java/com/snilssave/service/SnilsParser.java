package com.snilssave.service;

import com.snilssave.DAO.SnilsSaveDB;
import com.snilssave.modele.SnilsByAdditionalDataResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SnilsParser {
    public void snilsDataParser(File file) throws ParserConfigurationException, IOException, SAXException, SQLException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);//в переменной документ лежит результат парсинга

        SnilsSaveDB saveDB = new SnilsSaveDB();

        NodeList snilsByAdditionalDataResponseNodeList = document.getElementsByTagName("ns2:SnilsByAdditionalDataResponse");//бежим по объектам с тегом ns2:SnilsByAdditionalDataResponse

        List<SnilsByAdditionalDataResponse> snilsByAdditionalDataResponseList = new ArrayList<>();//список объектов тега ns2:SnilsByAdditionalDataResponse

        for (int i = 0; i < snilsByAdditionalDataResponseNodeList.getLength(); i++) {//бежим по объектам с тегом ns2:SnilsByAdditionalDataResponse
            if (snilsByAdditionalDataResponseNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {//проверка тегов. что бы брать между скобками значения
                Element snilsByAdditionalDataResponseElement = (Element) snilsByAdditionalDataResponseNodeList.item(i);//приведение ноды к элементу

                SnilsByAdditionalDataResponse snilsByAdditionalDataResponse = new SnilsByAdditionalDataResponse();//создаём объект тега ns2:SnilsByAdditionalDataResponse

                NodeList childNodes = snilsByAdditionalDataResponseElement.getChildNodes();//объявляем список внутренних элементов тега ns2:SnilsByAdditionalDataResponse
                for (int j = 0; j < childNodes.getLength(); j++) {//бежим по списку внутренних элементов
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {//проверяем, что элемент по типу является тем что нам нужно
                        Element childElement = (Element) childNodes.item(j);

                        switch (childElement.getNodeName()) {//проверяем, что это тот элемент который нунжен
                            case "FamilyName": {//находим тэг в файле
                                snilsByAdditionalDataResponse.setFamilyName(childElement.getTextContent());//передаём значение
                            } break;

                            case "FirstName": {
                                snilsByAdditionalDataResponse.setFirstName(childElement.getTextContent());
                            } break;

                            case "Patronymic": {
                                snilsByAdditionalDataResponse.setPatronymic(childElement.getTextContent());
                            } break;
                            case "ns2:Snils": {
                                snilsByAdditionalDataResponse.setSnilsNum(childElement.getTextContent());
                            } break;
                            case "ns2:BirthDate": {
                                snilsByAdditionalDataResponse.setBirthDate(childElement.getTextContent());
                            } break;
                            case "ns2:Gender": {
                                snilsByAdditionalDataResponse.setGender(childElement.getTextContent());
                            }

                        }
                    }
                }
                snilsByAdditionalDataResponseList.add(snilsByAdditionalDataResponse);
            }
        }
        String s = snilsByAdditionalDataResponseList.toString().replace("[","").replace("]","");
        System.out.println(s);
        saveDB.snilsInsert(s);

        /**ToDo определиться нужны ли эти данные
        if (document.getElementsByTagName("PassportRF")!=null) {

            NodeList passportRFNodeList = document.getElementsByTagName("PassportRF");
            List<SnilsPassportRF> snilsPassportRFList = new ArrayList<>();
            for (int i = 0; i < passportRFNodeList.getLength(); i++) {
                if (passportRFNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element snilsPassportRFElement = (Element) passportRFNodeList.item(i);

                    SnilsPassportRF snilsPassportRF = new SnilsPassportRF();

                    NodeList childPassportRFNodes = snilsPassportRFElement.getChildNodes();
                    for (int j = 0; j < childPassportRFNodes.getLength(); j++) {
                        if (childPassportRFNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element childPassportRFElement = (Element) childPassportRFNodes.item(j);

                            switch (childPassportRFElement.getNodeName()) {
                                case "Series": {
                                    snilsPassportRF.setSeries(Integer.valueOf(childPassportRFElement.getTextContent()));
                                }
                                break;
                                case "Number": {
                                    snilsPassportRF.setNumber(Integer.valueOf(childPassportRFElement.getTextContent()));
                                }
                                break;
                                case "IssueDate": {
                                    snilsPassportRF.setIssueDate(childPassportRFElement.getTextContent());
                                }
                                break;
                                case "Issuer": {
                                    snilsPassportRF.setIssuer(childPassportRFElement.getTextContent());
                                }
                            }
                        }
                    }
                    snilsPassportRFList.add(snilsPassportRF);
                }
            }
            snilsPassportRFList.forEach(System.out::println);
        }*/
    }
}
