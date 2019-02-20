1. What Is Demo Automation project about?
2. How the project structure looks like?
3. What are the preconditions?
4. How to run tests with Cify Framework?
5. How to add new tests?
6. Learn more about Cify Framework

## What Is Demo Automation project about?
Demo Automaton Project is a test automation project.

Two scenarios have been automated for Gymwolf webpage:
  a) Initial customer registration
  b) Search for specific exercise
 
## How the project structure looks like?

### Project structure overview
```
    /
    |-- build
    |   |-- cify
    |       |-- log
    |-- gradle
    |   |-- wrapper
    |-- src
    |   |-- test
    |       |-- groovy
    |           |-- impl
    |           |-- steps
    |       |-- resources
    |           |-- data
    |           |-- features
    |-- build.gradle
    |-- fullsuite.properties
    |-- capabilities.json
    |-- configuration.json
    |-- data.json
    |-- README.md
```

**build/cify/log/** - Project logs  
**gradle/wrapper/** - Gradle wrapper  
**src/test/groovy/impl** - Implementation layer, client specific implementation  
**src/test/groovy/steps** - Cucumber step definitions  
**src/test/resources/features** - Cucumber Feature files
**fullsuite.properties** - Project parameters for fullsuite execution  
**capabilities.json** - Device list for full execution  
**configuration.json** - Device information for local right-click-and-play execution  
**data.json** - Environment specific information like url, login etc

## What are the preconditions?

* Java 8
* IntelliJ IDEA (or similar IDE)


## How to run tests with Cify Framework?

Options for running tests with Cify Framework:
* Right click and play (plug-and-play)
* Run from command line (cify-runner)

### Plug-And-Play

#### Precondition for plug-and-play

Plug-and-play will use **configuration.json** for configuration file.

#### Steps

1. Navigate to Cucumber Feature file that you would like to run
1. Find Scenario you would like to run
1. Right click on Scenario/Right click on Feature
1. Click Run

### With Cify Runner

Cify funner will use **capabilities.json** and **.properties** files for configuration.

Runner gives multiple options to trigger tests and test suites.

Gradle wrapper is used in the project. We can trigger gradle tasks like following:

* ./gradlew <task> (on Unix-like platforms such as Linux and Mac OS X)
* gradlew <task> (on Windows using the gradlew.bat batch file)


#### Run with properties file

Running the command below will trigger all scenarios with tag specified in **fullsuite.properties**

```

./gradlew cucumber -Penv=fullsuite


```

#### Change browser for test execution

1. If running test via plug-and-play change in **configuration.json** browser capability parameters
2. If running test via plug-and-play change in **capabilities.json** browser capability parameters


#### Defaults 

Defaults is a optional parameter in capabilities json. User can define capabilities for 3 device categories (browser, android, iOS). If default is defined for one category then it will be added to every capability variation (if not defined in the set). 

#### Set

Set is a list of capabilities to test against. User can define as much capabilities for each device category as needed. Runner will create variations that every capability is tested with every other capabilities from other category.  

Valid capability file structure:
```
 {
   "set": {
     "android": [
       {
          "capability": "android",
          "UIType": "MobileAndroidApp",
          "deviceName": "First Android device",
          "app": "src/test/resources/applications/DNATV.apk"
       },
       {
          "capability": "android",
          "UIType": "MobileAndroidApp",
          "deviceName": "Second Android device",
          "app": "src/test/resources/applications/DNATV.apk"       },
       {
          "capability": "android",
          "UIType": "MobileAndroidApp",
          "deviceName": "Third Android device",
          "app": "src/test/resources/applications/DNATV.apk"       
       }
     ]
   }
 }
```

In this case there would be 4 different suites. One for each device in the list.

## How to add new tests?

### Cucumber
Cucumber features are located in src/test/resources/features folder.  
Users can add features like default cucumber requires.  
Add **@TODO** tag to feature or scenario when it's not implemented.  

```
@TODO
Scenario: Verify LiveTV view
    Given user opens Android application
    And user dismisses notifications
    And user taps cancel on login popup
    And user skips tutorial
    And user opens menu
    And user taps Live TV in menu
    When user scrolls DOWN on the live TV view
    Then Live TV view scrolls correctly
```

### Step definitions

Step definitions are located in **src/test/groovy/steps** folder.  
Users can add step definitions like default cucumber requires.

```
And(~/^user scrolls (.*) on the categories view$/) { String direction ->
    impl.ActionsImpl.getCategoriesActions().scrollProgramList(direction)
}
```

### Implementation

Create interface for needed class Example:
```
trait IFavouritesActions {

    FavouritesPageObjects favouritesPageObjects
    Device device

    /**
     * Scrolls the favourite channel list in given direction. Title of the first program in list is
     * saved to the TestDataManager.
     * @param direction scroll direction: UP, DOWN, LEFT, RIGHT
     */
    void scrollFavouritesChannelList(String direction) {
        setTestData(FIRST_PROGRAM_TITLE, favouritesPageObjects.getRowTitle().getText())
        scrollElement(device, favouritesPageObjects.getChannelList(), direction)
    }
}

```

Implement this interface with available UITypes (Currently there are three: DesktopWeb, MobileAndroidApp, MobileIOSApp)
```
class FavouritesActionsMobileAndroidApp implements IFavouritesActions {

    FavouritesActionsMobileAndroidApp(Device device) {
        this.device = device
        this.favouritesPageObjects = new FavouritesPageObjects()
    }
}
```

Add new class to impl.ActionsImpl class.

```
    /**
     * Gets Favourite actions for current device
     * @return IFavouritesActions class instance
     */
    static IFavouritesActions getFavouritesActions() {
           (IFavouritesActions) getCustomActions(DeviceManager.getInstance().getActiveDevice(TestDataManager.getActiveDevice()), IMPLEMENTATION_PACKAGE + "favourites.actions.FavouritesActions")
       }

```


### Page Objects

Page objects hold all the elements that tests need.

```
class FavouritesPageObjects extends PageObjects {

    FavouritesPageObjects() {
        super(DeviceManager.getInstance().getActiveDevice())
    }

    @AndroidFindBy(id = "programs_list_view")
    WebElement channelList

    @AndroidFindBy(id = "vod_channel_row_title")
    WebElement rowTitle

    @AndroidFindBy(id = "tabs")
    WebElement tabSection

    By tabTitles = By.className("android.widget.TextView")

    @AndroidFindBy(id = "programs_list_view")
    WebElement programsList

    @AndroidFindBy(id = "program_name")
    WebElement programTitle

    @AndroidFindBy(id = "program_date")
    WebElement programDate

}

```


## Learn more about Cify Framework

**Cify Framework**  
Framework is responsible for managing communication with devices, and handling device actions (click, touch, tap, fillIn, sendKeys etc.) independently from device platform.  
Learn more from [GitHub](https://github.com/fobsolutions/cify-framework)  
**Cify Runner**  
Runner is responsible for parameters management, test configuration and test execution.  
Learn more from [GitHub](https://github.com/fobsolutions/cify-runner)    
**Cify Device Farm**  
Device Farm provides cross platform Selenium grid nodes.  
Learn more from [GitHub](https://github.com/fobsolutions/cify-device-farm)    
