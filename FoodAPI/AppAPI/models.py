from django.db import models
from django.db.models import Avg

# Create your models here.
class Rest(models.Model):
    restName = models.CharField(max_length=50, null=False, default = " ")
    zipcode = models.PositiveIntegerField( null=False, default = 0)
    banner = models.ImageField( null=True, default = '/media/ic_launcher_img_foreground.jpg')  
    website = models.URLField(max_length=50, null=False, default = " ")
    phone = models.PositiveIntegerField( null=False, default = 0)
    category = models.PositiveIntegerField(null = True, default= 0)

    @property
    def restRating(self):
        avg = Rating.objects.filter(restId=self.pk).aggregate(Avg('rating'))['rating__avg']
        return avg

    @property
    def restPrice(self):
        avg = Item.objects.filter(restId=self.pk).aggregate(Avg('itemPrice'))['itemPrice__avg']
        return avg

    def __str__(self):
        return self.restName


class Item(models.Model):
     itemName = models.CharField(max_length=50, null=False, default = " ")
     itemPrice = models.FloatField( null=False, default = 0)
     itemRating = models.FloatField( null=False, default = 0)
     description =  models.CharField(max_length=200, null=False, default = " ")
     restId =  models.ForeignKey(Rest, on_delete=models.CASCADE, default = 0)
     def __str__(self):
       return self.itemName

class User(models.Model):
    userEmail = models.EmailField(max_length=50, null=False, primary_key=True, default = " ")
    password = models.CharField(max_length=50,  null=False, default = " ")
    name = models.CharField(max_length=50,  null=False, default = " ")

    def __str__(self):
       return self.name

class Rating(models.Model):
    userEmail = models.ForeignKey(User, on_delete=models.CASCADE) # removed , related_name='+'
    restId =  models.ForeignKey(Rest, on_delete=models.CASCADE) # removed , related_name='+'
    review = models.CharField(max_length=300, null=True)
    rating = models.PositiveIntegerField()

    def __str__(self):
       return self.review
    
class RatingItem(models.Model):
    userEmail = models.ForeignKey(User, on_delete=models.CASCADE) # removed , related_name='+'
    restId =  models.ForeignKey(Rest, on_delete=models.CASCADE) # removed , related_name='+'
    itemId =  models.ForeignKey(Item, on_delete=models.CASCADE)
    review = models.CharField(max_length=300, null=True)
    rating = models.PositiveIntegerField()

    def __str__(self):
       return self.userEmail

