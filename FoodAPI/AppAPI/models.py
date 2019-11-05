from django.db import models

# Create your models here.
class Rest(models.Model):
    restName = models.CharField(max_length=50, null=True)
    zipcode = models.PositiveIntegerField( null=True)
    restRating = models.FloatField( null=True)
    #banner = models.ImageField( null=True)  #I need to do more to get images to work
    website = models.CharField(max_length=50, null=True)
    phone = models.PositiveIntegerField( null=True)
    #how to do reviews? link to another table?
    restPrice = models.FloatField( null=True)

    def __str__(self):
        return self.restName


class Item(models.Model):
     itemName = models.CharField(max_length=50, null=True)
     itemPrice = models.PositiveIntegerField( null=True)
     itemRating = models.FloatField( null=True)
     description =  models.CharField(max_length=200, null=True)
     #how to do reviews? link to another table?
     restId =  models.PositiveIntegerField( null=True) #need to change this to a foreing key

     def __str__(self):
       return self.itemName

class User(models.Model):
    userEmail = models.CharField(max_length=50, null=True)
    password = models.CharField(max_length=50,  null=True)
    name = models.CharField(max_length=50,  null=True)

    def __str__(self):
       return self.name