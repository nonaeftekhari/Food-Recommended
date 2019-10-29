from django.shortcuts import render
from rest_framework import viewsets
from .models import *
from .serializers import *

# Create your views here.
class restView(viewsets.ModelViewSet):
    queryset = Rest.objects.all()
    serializer_class = restSerializer

class itemView(viewsets.ModelViewSet):
    queryset = Item.objects.all()
    serializer_class = itemSerializer