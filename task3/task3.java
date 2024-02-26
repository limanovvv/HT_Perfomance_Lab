package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class Parsing {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Чтение данных из файлов
            JsonNode valuesNode = mapper.readTree(new File("values.json"));
            JsonNode testsNode = mapper.readTree(new File("tests.json"));

            // Обновление значений в структуре testsNode
            updateTestsNode(testsNode, valuesNode);

            // Запись обновленных данных в файл report.json
            mapper.writeValue(new File("report.json"), testsNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateTestsNode(JsonNode testsNode, JsonNode valuesNode) {
        // Перебор всех тестов
        for (JsonNode testNode : testsNode.get("tests")) {
            int testId = testNode.get("id").asInt();
            // Поиск значения для данного теста
            for (JsonNode valueNode : valuesNode.get("values")) {
                if (valueNode.get("id").asInt() == testId) {
                    ((ObjectNode) testNode).put("value", valueNode.get("value").asText());
                }
            }
            // Рекурсивный вызов для вложенных тестов
            if (testNode.has("values")) {
                updateTestsNode(testNode, valuesNode);
            }
        }
    }
}
