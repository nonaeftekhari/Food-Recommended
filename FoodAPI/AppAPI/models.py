from django.db import models

# Create your models here.
class Rest(models.Model):
    restName = models.CharField(max_length=50, null=False, default = " ")
    zipcode = models.PositiveIntegerField( null=False, default = 0)
    restRating = models.FloatField( null=False, default = 0)
    #banner = models.ImageField( null=True)  #I need to do more to get images to work
    website = models.CharField(max_length=50, null=False, default = " ")
    phone = models.PositiveIntegerField( null=False, default = 0)
    #how to do reviews? link to another table?
    restPrice = models.FloatField( null=False, default = 0)

    def __str__(self):
        return self.restName


class Item(models.Model):
     itemName = models.CharField(max_length=50, null=False, default = " ")
     itemPrice = models.FloatField( null=False, default = 0)
     itemRating = models.FloatField( null=False, default = 0)
     description =  models.CharField(max_length=200, null=False, default = " ")
     #how to do reviews? link to another table?
     restId =  models.ForeignKey(Rest, on_delete=models.CASCADE, default = 0)
     def __str__(self):
       return self.itemName

class User(models.Model):
    userEmail = models.CharField(max_length=50, null=False, primary_key=True, default = " ")
    password = models.CharField(max_length=50,  null=False, default = " ")
    name = models.CharField(max_length=50,  null=False, default = " ")

    def __str__(self):
       return self.name

class Rating(models.Model):
    userEmail = models.ForeignKey(User, on_delete=models.CASCADE)
    restId =  models.ForeignKey(Rest, on_delete=models.CASCADE)
    itemId =  models.ForeignKey(Item, on_delete=models.CASCADE)
    review = models.CharField(max_length=300, null=True)
    rating = models.PositiveIntegerField()

    def __str__(self):
       return self.userEmail

