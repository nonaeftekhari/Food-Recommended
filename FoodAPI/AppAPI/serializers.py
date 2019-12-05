from rest_framework import serializers
from .models import *

class restSerializer(serializers.ModelSerializer):
    restRating = serializers.FloatField

    class Meta:
        model = Rest
        fields = ['id', 'restName', 'banner', 'zipcode', 'restRating', 'website', 'phone', 'restPrice', 'category']
        

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
        fields = ['id', 'userEmail', 'restId',  'review', 'rating'] 

class ratingItemSerializer(serializers.ModelSerializer):
    class Meta:
        model = RatingItem
        fields = ['id', 'userEmail', 'restId', 'itemId', 'review', 'rating'] 

class ratingResponseSerializer(serializers.ModelSerializer):
    class Meta:
        model = RatingResponse
        fields = ['id', 'ratingId', 'response'] 
