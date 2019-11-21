from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from rest_framework import viewsets
from rest_framework.parsers import JSONParser
from .models import *
from .serializers import *

# Create your views here.




# List rests and post single rest
@csrf_exempt
def restList(request):
    if request.method == 'GET':
        restObj = Rest.objects.all()
        serializer = restSerializer(restObj, many=True)
        return JsonResponse(serializer.data, safe=False)

    elif request.method == 'POST':
        data = JSONParser().parse(request)
        serializer = restSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data, status=201)
        return JsonResponse(serializer.errors, status=400)

    else:
        return HttpResponse(status=404)

#pull info on a single rest by pk
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

#pull all rest in a zip code
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

#get all items or post an item
@csrf_exempt
def itemList(request):
    if request.method == 'GET':
        itemObj = Item.objects.all()
        serializer = itemSerializer(itemObj, many=True)
        return JsonResponse(serializer.data, safe=False)

    elif request.method == 'POST':
        data = JSONParser().parse(request)
        serializer = itemSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data, status=201)
        return JsonResponse(serializer.errors, status=400)

    else:
        return HttpResponse(status=404)

#get info on an item from pk
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

#get all items from a rest
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

#get all users and post a user
@csrf_exempt
def userList(request):
    if request.method == 'GET':
        userObj = User.objects.all()
        serializer = userSerializer(userObj, many=True)
        return JsonResponse(serializer.data, safe=False)

    elif request.method == 'POST':
        data = JSONParser().parse(request)
        serializer = userSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data, status=201)
        return JsonResponse(serializer.errors, status=400)

    else:
        return HttpResponse(status=404)

 #get user by pk
@csrf_exempt
def userID(request, pk):
    try:
        userObj = User.objects.get(pk=pk)
    except User.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = userSerializer(userObj)
        return JsonResponse(serializer.data)

    else:
        return HttpResponse(status=404)

#get all ratings and post a rating
@csrf_exempt
def ratingList(request):
    if request.method == 'GET':
        ratingObj = Rating.objects.all()
        serializer = ratingSerializer(ratingObj, many=True)
        return JsonResponse(serializer.data, safe=False)

    elif request.method == 'POST':
        data = JSONParser().parse(request)
        serializer = ratingSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data, status=201)
        return JsonResponse(serializer.errors, status=400)

    else:
        return HttpResponse(status=404)

#get all reviews from a rest
@csrf_exempt
def ratingRest(request, restId):
    try:
        ratingObj = Rating.objects.get(restId=restId)
    except Rating.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        ratingObj = Rating.objects.all()
        serializer = ratingSerializer(ratingObj, many=True)
        return JsonResponse(serializer.data, safe=False)

    else:
        return HttpResponse(status=404)

#get all ratings from on user
@csrf_exempt
def ratingUser(request, userEmail):
    try:
        ratingObj = Rating.objects.get(userEmail=userEmail)
    except Rating.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        ratingObj = Rating.objects.all()
        serializer = ratingSerializer(ratingObj, many=True)
        return JsonResponse(serializer.data, safe=False)

    else:
        return HttpResponse(status=404)
