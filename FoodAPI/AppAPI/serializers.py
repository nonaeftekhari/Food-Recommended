from rest_framework import serializers
from .models import *

class restSerializer(serializers.ModelSerializer):
    class Meta:
        model = Rest
        fields = ['id', 'name', 'zipcode', 'rating']


class itemSerializer(serializers.ModelSerializer):
    class Meta:
        model = Item
        fields = ['id', 'name', 'cost', 'rating']