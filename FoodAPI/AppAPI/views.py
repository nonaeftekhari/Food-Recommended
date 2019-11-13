from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from rest_framework import viewsets
from rest_framework.parsers import JSONParser
from .models import *
from .serializers import *

# Create your views here.





@csrf_exempt
def restList(request):
    if request.method == 'GET':
        restObj = Rest.objects.all()
        serializer = restSerializer(restObj, many=True)
        return JsonResponse(serializer.data, safe=False)
    else:
        return HttpResponse(status=404)

@csrf_exempt
def restID(request, pk):
    try:
        restObj = Rest.objects.get(pk=pk)
    except Rest.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = restSerializer(restObj)
        return JsonResponse(serializer.data)
    else:
        return HttpResponse(status=404)

@csrf_exempt
def restZip(request, zipcode):
    try:
        restObj = Rest.objects.filter(zipcode=zipcode)
    except Rest.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = restSerializer(restObj, many=True)
        return JsonResponse(serializer.data, safe=False)
    else:
        return HttpResponse(status=404)

@csrf_exempt
def itemList(request):
    if request.method == 'GET':
        itemObj = Item.objects.all()
        serializer = itemSerializer(itemObj, many=True)
        return JsonResponse(serializer.data, safe=False)
    else:
        return HttpResponse(status=404)

@csrf_exempt
def itemID(request, pk):
    try:
        itemObj = Item.objects.get(pk=pk)
    except Item.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        itemObj = Item.objects.all()
        serializer = itemSerializer(itemObj, many=True)
        return JsonResponse(serializer.data, safe=False)
    else:
        return HttpResponse(status=404)

@csrf_exempt
def itemRest(request, restId):
    try:
        itemObj = Item.objects.get(restId=restId)
    except Item.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        itemObj = Item.objects.all()
        serializer = itemSerializer(itemObj, many=True)
        return JsonResponse(serializer.data, safe=False)
    else:
        return HttpResponse(status=404)

@csrf_exempt
def userList(request):
    if request.method == 'GET':
        userObj = User.objects.all()
        serializer = userSerializer(userObj, many=True)
        return JsonResponse(serializer.data, safe=False)
    else:
        return HttpResponse(status=404)

@csrf_exempt
def userID(request, pk):
    try:
        userObj = User.objects.get(pk=pk)
    except Item.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        userObj = Item.objects.all()
        serializer =userSerializer(userObj, many=True)
        return JsonResponse(serializer.data, safe=False)
    else:
        return HttpResponse(status=404)

@csrf_exempt
def userList(request):
    if request.method == 'GET':
        userObj = User.objects.all()
        serializer = userSerializer(userObj, many=True)
        return JsonResponse(serializer.data, safe=False)
    else:
        return HttpResponse(status=404)

"""

class restView(viewsets.ModelViewSet):
    queryset = Rest.objects.all()
    serializer_class = restSerializer

class itemView(viewsets.ModelViewSet):
    queryset = Item.objects.all()
    serializer_class = itemSerializer

class userView(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = userSerializer

class ratingView(viewsets.ModelViewSet):
    queryset = Rating.objects.all()
    serializer_class = ratingSerializer

"""