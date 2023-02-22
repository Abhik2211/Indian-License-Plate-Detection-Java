# MINOR PROJECT 1 (LICENSE PLATE DETECTION IN JAVA)


A project where the license plate number is extracted from image of a vehicle using Object detection and Character recognition techniques.



## Introduction :rocket:
--------------------------
This aim of this project “Forensic Analysis: License plate detection Criminal
Investigation” is to make the detection and further prevention of crimes easier. This can
be achieved by detecting the car License Plate Number which could narrow down the
search radius. For this, we have created a model, which performs various operations on
input that helps to extract license plates numbers.
Finally, the result of the first phase, that is getting the license plate number which is
then tested against the criminal database to find relevant matches.


## Target Beneficiary :cop:
---------------------------
It has a lot of applications mainly for the following departments :-
- Law Enforcements
  - Police
  - Traffic Police
- Anti-Terrorist Forces
  - RAW
  - CBI
  - NIA
- Government Organizations 
- Private Security Firms


## Approach :boom:
---------------------------
The approach for the project is as follows: -

![image](https://user-images.githubusercontent.com/92619018/206591061-415ca863-b89f-4375-9d35-117dc805f933.png)


![image](https://user-images.githubusercontent.com/92619018/206591040-911e4c09-764e-4aa8-af57-04bc911dbce8.png)


1. Read the image and perform the necessary transformations on it as part of pre-processing. 
This includes Downsampling and Grayscale conversion.
2. Apply feature extraction on the image to isolate our candidate i.e., license plates. 
This includes, Edge detection, Adaptive Thresholding and making a bounding box.
3. Finally, recoganize the characters of the license plate using Optical Character Recognition.
We will store this data in the database.
  
## Dataset :floppy_disk:
------------------
1. Our primary dataset consisted of pictures clicked on our own. The dataset can be downloaded from here
https://upesstd-my.sharepoint.com/:f:/g/personal/500083764_stu_upes_ac_in/EjcmlM172GhAu2vN725ciZgBSnKlqREY4Md4HazGxTJ-Yg?e=Wxlvp5
2. The second dataset is made with assumption. It is database of fake criminals. It has their information as well as the information of the vehicle.


## Software Used :computer:
-------------------
- Programming Language -> Java
- IDE -> Eclipse
- Libraries -> OpenCV, Marvin, Swing, Tesseract



## Methadology :scroll:
--------------------
### <ins>Input Phase</ins>
1.1 **<ins>Input the image from the dataset</ins>**

### <ins>Pre-Processing Phase</ins>
2.1 **<ins>After we input the image we downsample it.</ins>**
```
WHY DOWNSCALE THE IMAGE?
Since the input image is of high resolution, it poses a high computational cost for detecting license plate in an image. 
To address this issue we downscale the input image. 
However downscaling may cause loss of information and lead to a decrease in performance of detection. 
For this reason a lot of earlier developed methods skip this step. 
A common problem statement that arises is "how to balance detection accuracy and runtime efficiency"?  
We have proposed a method that can substantially reduce the image size without a major decrease in performance.
Since we know that the width of license plate is more than height and characters on license are printed in horizontal direction. 
Therefore we define different scaling factors for vertical and horizontal direction to downscale input image.
We can also compress more data in horizontal direction because the width of license plate is greater. 
Also it makes the resulting image compact which helps later in featuer extraction since there is lesser noise.
Finally, we use INTER_AREA interpolation method that is built into opencv for image downsampling.
# We used INTER_AREA because it works best when we need to shrink an image. 
INTER_AREA is Bilinear Interpolation with coefficients 1 and 0.
```

![7](https://user-images.githubusercontent.com/92619018/206591134-f246b40d-1c26-4e52-bf33-edccb266bc40.jpg)



**Fig 1: This is the original input image.**<br/><br/><br/><br/>



![downgrade](https://user-images.githubusercontent.com/92619018/206590372-7f68f5fe-ba55-4150-bfb3-85cd6ff8a465.jpg)

**Fig 2: This is the downscaled image.**<br/><br/><br/><br/>


![Presentation1](https://user-images.githubusercontent.com/92619018/200835728-14bbf503-f5cb-4adf-bd56-6b62eb23fc31.png)

**Fig 3(a): The image shows the result of edge detection with downsampling applied to it.**

**Fig 3(b): The image shows the result of edge detection without applying downsampling to it.**

**NOTE: THIS IMAGE IS JUST FOR DEMONSTRATION**<br/><br/><br/><br/>





2.2 **<ins>Convert the image into grayscale using the inbuilt opencv method. (RGB2GRAY)</ins>**

![gray](https://user-images.githubusercontent.com/92619018/206590504-5e68d6a9-6e1e-45c1-97fb-c14a5a51de8c.png)


**Fig 4: The image shows the result after applying cvtColor function and converting RGB image to Grayscale image.**<br/><br/><br/><br/>



### <ins>Feature Extraction Phase</ins>

3.1 **<ins>Edge Detection</ins>** 

  3.1.1 **Blurring** -> Blurring is a simple and frequently used image processing operation in order to reduce noise.
  
  ![image](https://user-images.githubusercontent.com/92619018/206590630-35b908c8-5ea8-43a3-832e-287f607742ea.png)


  **Fig 5: The image shows the result after applying the blur function to the grayscale image.**
  
  
  ```
  From the figure it may seem that blurring didn't really create any difference in the image.
  Blurring Function smoothens out some of the hard edges that would have become noise when performing edge detection.
  ```
  
  ![Presentation2](https://user-images.githubusercontent.com/92619018/200842996-03abe1ab-4dc2-4d5a-aeed-a360299c3ae6.png)


  **Fig 6: This image shows that there is some advantage by applying blur to the grayscale image.**
  
  
  **NOTE: THIS IMAGE IS JUST FOR DEMONSTRATION**<br/><br/><br/><br/>
  
  
  
  3.1.2 **Canny Algorithm** -> The function finds edges in the input image and marks them in the output map edges using the Canny algorithm.
  
  
  ![edge](https://user-images.githubusercontent.com/92619018/206590788-d86d4f05-cca3-4f2f-bea9-f6ee3266935d.png)


  **Fig 7: This image shows the result after applying the Canny Function. This gives us an output with only the hard edges.**<br/><br/><br/><br/>
  
  
3.2 **<ins>Adaptive Thresholding</ins>** -> Applies an adaptive threshold to an array. Threshold value is calculated for smaller regions.
    
 ![threshold](https://user-images.githubusercontent.com/92619018/206590824-7c9976dd-fa8c-44ab-89e0-57b3dc34a95a.png)


  **Fig 8: This image shows the result after applying Adaptive Thresholding to the Edge Detected Image.** <br/><br/><br/><br/>
  
  

3.3 **<ins>Bounding Box</ins>** -> We are using the Marvin Framework to create a box around the license plate. This is simply to isolate our candidate.

  ![image](https://user-images.githubusercontent.com/92619018/206591315-6005644e-d250-481a-9f26-826ae83bc0b2.png)



  **Fig 9: This image shows the result after applying the <sub>findTextRegions</sub> function of the Marvin Framework.**
    
  ```
  As you can see in the figure that the Marvin Framework provides a strong and robust method
  to detect any characters or text regions in your image. This function has created a 
  bounding box around all the texts and characters it sees in the image.
  ```

### <ins>Plate Recognition</ins>
4.1 **<ins>Optical Character Recognition</ins>** -> We are using the Tesseract or Tess4J library to perform optical character recognition. This library had to be trained for recognizing Indian License Plate Numbers. For training the Tess4J you need to use the JTessBox Editor and the Indian License Plates Fonts Dataset. You can send me an email for more information regarding this (suyashthakur7@gmail.com)

![image](https://user-images.githubusercontent.com/92619018/206589559-e68cbbaa-0857-4fc9-8299-fc18fdc50790.png)

 **Fig 10: This image shows the result after applying the <sub>doOCR</sub> function of the Tess4J Framework.**

### <ins>Output</ins>
5.1 **<ins>Final Outputs</ins>** -> We finally pass the extracted text to a method that searches the criminal database and returns all the information if the license plate matches any record in the criminal database.

![image](https://user-images.githubusercontent.com/92619018/206589945-19d1c27f-91e1-43fe-bd08-d1b007c899db.png)

**Fig 11: This image shows if the person is involved in crime or not. If output of OCR matched, then person is involved, otherwise they are not.**

![image](https://user-images.githubusercontent.com/92619018/206590103-da7ddf98-baf6-4543-a057-8685808d6a58.png)

**Fig 12: This image shows details of the person whose record was matched in the criminal database.**
