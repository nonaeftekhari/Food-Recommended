from rest_framework import serializers
from .models import *

class restSerializer(serializers.ModelSerializer):
    class Meta:
        model = Rest
        fields = ['id', 'restName', 'banner', 'zipcode', 'restRating', 'website', 'phone', 'restPrice']
        #need to still ad image and reviews

class itemSerializer(serializers.ModelSerializer):
    class Meta:
        model = Item
        fields = ['id', 'itemName', 'itemPrice', 'itemRating', 'description', 'restId']


class userSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ['userEmail', 'password', 'name']


class ratingSerializer(serializers.ModelSerializer):
    class Meta:
        model = Rating
        fields = ['id', 'userEmail', 'restId',  'review', 'rating'] #'itemId', removed item id