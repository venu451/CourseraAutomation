@tag
Feature: Language Learning Feature
  clicking on the each language

  @sanity
  Scenario: selecting the Chines language under language learning category
    and gathering the number of courses available for each level

    Given User opens the application
    When user clicks on Explore dropdown
    And select the language learning subject
    And select All Language Courses section
    Then it should load a new page with all courses
    And take all the available languages for each level and extracting number of courses available for each level

  #Scenario: selecting the english language under language learning category
    #Given User opens the application
    #When user clicks on Explore dropdown
    #And select the language learning subject
    #And select english language
    #Then it should load a new page with courses
    #And take the count of number of courses available in each level
#
  #Scenario: selecting the french language under language learning category
    #Given User opens the application
    #When user clicks on Explore dropdown
    #And select the language learning subject
    #And select french language
    #Then it should load a new page with courses
    #And take the count of number of courses available in each level
#
  #Scenario: selecting the korean language under language learning category
    #Given User opens the application
    #When user clicks on Explore dropdown
    #And select the language learning subject
    #And select korean language
    #Then it should load a new page with courses
    #And take the count of number of courses available in each level
#
  #Scenario: selecting the mandarin language under language learning category
    #Given User opens the application
    #When user clicks on Explore dropdown
    #And select the language learning subject
    #And select mandarin language
    #Then it should load a new page with courses
    #And take the count of number of courses available in each level
#
  #Scenario: selecting the spanish language under language learning category
    #Given User opens the application
    #When user clicks on Explore dropdown
    #And select the language learning subject
    #And select spanish language
    #Then it should load a new page with courses
    #And take the count of number of courses available in each level
