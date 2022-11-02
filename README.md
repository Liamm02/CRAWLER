# CRAWLER
Crawler for search engine

## Overview 📋
The code performs the following functions:

1- Check if every file and folder we need is ready, and prepare them if they are not.

2- Preprocesses the data in the text collection (stop words removal, stemming, removing punctuations etc.)

3- Extract metadata from text files.

4- Download and store documents.

5- Repeat the process every minute.

## Running the code 🔧
*Java 17 and json are required to run the code*

Ensure all the files from the repo are present in the same directory.

Open the project in any preferred IDE of your choice and run the Main.java file, on the Crawler_Package foulder.

## Detailed List of Functionalities Implemented ⚙️
### In the foulder InvertedIndex:

It is similar to the inverted index project made previously in python but now in java

### In the foulder Crawler

### In the foulder Crawler_Package

Main module of the project, automates the process to do it every minute

### In the foulder Downloader

Download and store the files of the Project Gutenberg collection

### In the foulder MetaData_Extractor

Extract metadata from text file and save it in json format

## Built With 🛠️

* [Intellij Idea](https://www.jetbrains.com/es-es/idea/) - The text editor used.
* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - The java version used.
## Authors ✒️
* **Javier García**
* **Jesús Matos**
* **Liam Mahmud**
* **Krish Sadhwani**
