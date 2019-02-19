package impl.helpers

import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap
import io.cify.runner.utils.CifyExcelParser

class TestDataManager {

    private static final TEST_DATA_FILE = "build/cify/features/testdata/testdata-excel.json"
    private static final TEST_DATA_EXCEL = "src/test/resources/data/Test_Automation_Data.xls"
    private static final TEST_DATA_PROPERTIES = "build/cify/testdata/properties.json"
    private static final LOCAL_CONFIGURATION_DATA = "data.json"

    static LazyMap testData = [:]

    static LazyMap getTestData() {
        if (testData.isEmpty()) {
            initTestData()
        }
        return testData
    }

    static def getTestData(String dataKey) {
        return getTestData().get(dataKey)
    }


    static void addTestData(String key, def value) {
        getTestData().put(key, value)
    }

    /**
     * Initializes test data
     * @return
     */
    private static initTestData() {
        if (testData.isEmpty()) {
            File dataFile = new File(TEST_DATA_FILE)
            if (dataFile.isFile()) {
                testData = new JsonSlurper().parse(dataFile) as LazyMap
            } else {
                File excelFile = new File(TEST_DATA_EXCEL)
                if (excelFile.isFile()) {
                    testData = CifyExcelParser.parse(excelFile, "build/cify/features/testdata/")
                }
            }
            initLocalConf()
            initPropertiesData()
        }
    }

    /**
     * Init properties data
     * @return
     */
    private static initPropertiesData() {
        File propertiesData = new File(TEST_DATA_PROPERTIES)
        initConf(propertiesData)
    }

    /**
     * Init local config
     * @return
     */
    private static initLocalConf() {
        File localConf = new File(LOCAL_CONFIGURATION_DATA)
        initConf(localConf)
    }

    /**
     * Init test data from file
     * @param file
     * @return
     */
    private static initConf(File file) {
        if (file.isFile()) {
            LazyMap dataMap = new JsonSlurper().parse(file) as LazyMap
            dataMap.each {
                testData.put(it.key, it.value)
            }
        }
    }
}