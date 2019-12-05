from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from rest_framework import viewsets
from rest_framework.parsers import JSONParser
from .models import *
from .serializers import *

# Create your views here.


class userView(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = userSerializer

class restView(viewsets.ModelViewSet):
    queryset = Rest.objects.all()
    serializer_class = restSerializer

class itemView(viewsets.ModelViewSet):
    queryset = Item.objects.all()
    serializer_class = itemSerializer
   
class ratingView(viewsets.ModelViewSet):
    queryset = Rating.objects.all()
    serializer_class = ratingSerializer

class ratingItemView(viewsets.ModelViewSet):
    queryset = RatingItem.objects.all()
    serializer_class = ratingItemSerializer

class ratingResponseView(viewsets.ModelViewSet):
    queryset = RatingResponse.objects.all()
    serializer_class = ratingResponseSerializer

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

#get all rest in zip code and the right category
def restZipCat(request, zipcode, category):
    try:
        restObj = Rest.objects.filter(zipcode=zipcode, category=category)
    except Rest.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = restSerializer(restObj, many=True)
        return JsonResponse(serializer.data, safe=False)

    else:
        return HttpResponse(status=404)

#get info on an item from pk
@csrf_exempt
def itemID(request, pk):
    try:
        itemObj = Item.objects.filter(pk=pk)
    except Item.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = itemSerializer(itemObj, many=True)
        return JsonResponse(serializer.data, safe=False)

    else:
        return HttpResponse(status=404)

#get all items from a rest
@csrf_exempt
def itemRest(request, restId):
    try:
        itemObj = Item.objects.filter(restId=restId)
    except Item.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = itemSerializer(itemObj, many=True)
        return JsonResponse(serializer.data, safe=False)

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
        serializer =userSerializer(userObj)
        return JsonResponse(serializer.data)

    else:
        return HttpResponse(status=404)

#get all reviews from a rest
@csrf_exempt
def ratingRest(request, restId):
    try:
        ratingObj = Rating.objects.filter(restId=restId)
    except Rating.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = ratingSerializer(ratingObj, many=True)
        return JsonResponse(serializer.data, safe=False)

    else:
        return HttpResponse(status=404)

#get all ratings from on user
@csrf_exempt
def ratingUser(request, userEmail):
    try:
        ratingObj = Rating.objects.filter(userEmail=userEmail)
    except Rating.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = ratingSerializer(ratingObj, many=True)
        return JsonResponse(serializer.data, safe=False)

    else:
        return HttpResponse(status=404)

#get any response to ratings
@csrf_exempt
def ratingResponseID(request, ratingId):
    try:
        responseObj = RatingResponse.objects.filter(ratingId=ratingId)
    except responseObj.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = ratingResponseSerializer(responseObj, many=True)
        return JsonResponse(serializer.data, safe=False)

    else:
        return HttpResponse(status=404)