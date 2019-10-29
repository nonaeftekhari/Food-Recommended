from django.db import models

# Create your models here.
class Rest(models.Model):
    name = models.CharField(max_length=50)
    zipcode = models.PositiveIntegerField()
    rating = models.FloatField()

class Item(models.Model):
     name = models.CharField(max_length=50)
     cost = models.PositiveIntegerField()
     rating = models.FloatField()