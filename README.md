# YOPHA = `Yo`ur `Pha`rmacy
### What is YOPHA?

<img width="500" alt="스크린샷 2021-03-31 오후 8 34 47" src="https://user-images.githubusercontent.com/50359820/113138544-e1ef3c80-9260-11eb-8fb2-36f2f39dd58d.png">


* Application to offer the list of pharmacies considering the **`OTC's price and distance`** for users
* Target user : whoever want to check the prices of medicine
* Type : android application

`OTC :  medicines sold directly to a consumer without a requirement for a prescription from a healthcare professional, as opposed to prescription drugs`

_- https://en.wikipedia.org/wiki/Over-the-counter_drug_

***

## Motivation

<img width="800" alt="스크린샷 2021-03-31 오후 9 00 23" src="https://user-images.githubusercontent.com/50359820/113151628-3ea62380-9270-11eb-83ea-4071b0617f3c.png">

* In some cases, the difference in medicine(OTC) prices is **severe**
* Also, consumers **`couldn't find out`** the specific price of the medicine (unless you visit the pharmacy in person and ask) 

_References_
_1. http://sateconomy.co.kr/View.aspx?No=1013836_
_2. https://www.yna.co.kr/view/MYH20200221004800797_

## Objective
1. Offer **OTC price information** to consumer
2. Offer **search operation** for pharmacies around users
3. Offer **detailed information** (hours of operation, address, ...) of each pharmacy
4. Offer **database modification** with **user engagement**

 
## Dataset
<img width="732" alt="스크린샷 2021-03-31 오후 10 40 54" src="https://user-images.githubusercontent.com/50359820/113153559-2f27da00-9272-11eb-9547-77b8c8488890.png">

### We have 3 dataset table
* Drug      
       - Korea Consumer Agency's OTC price information data      
       - Drug type, Manufacturer, Name, Region, Price information      

![image](https://user-images.githubusercontent.com/64179014/121634727-0fa5fc80-cac0-11eb-8445-423cf6bcb79e.png)
![image](https://user-images.githubusercontent.com/64179014/121634772-24829000-cac0-11eb-9ba4-6449196b56c0.png)

* Pharmacy    
        - National Pharmacy Information Support Service Api     
        - Location, Operating hours, Phone number, Address       

![image](https://user-images.githubusercontent.com/64179014/121635402-23059780-cac1-11eb-9a41-fda9a06c7787.png)

* Test     
        - User input
        - Pharmacy address, Pharmacy name, Drugs

![image](https://user-images.githubusercontent.com/64179014/121635598-7a0b6c80-cac1-11eb-963e-e8defced5e98.png)

## Target
* Whoever want to check the prices of medicine




