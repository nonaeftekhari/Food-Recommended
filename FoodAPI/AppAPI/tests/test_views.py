import json
from rest_framework import status
from django.test import TestCase, Client
from django.urls import reverse
from django.urls import resolve

from ..models import *
from ..serializers import *

client = Client()

"""
class getAllRestZip(TestCase):
    def setUp(self):
        self.restBuddys = Rest.objects.create(
            restName='Buddys', zipcode = 48201, website = 'Buddys.com', phone = 3132342345, category = 0)
        self.restSyThai = Rest.objects.create(
            restName='Sy Thai', zipcode = 48201, website = 'SyThai.com', phone = 3132488736, category = 1)

    def test_get_all_rest_zip(self):
        response = client.filter(
            reverse('restZip', kwargs={'zipcode' : self.restBuddys.zipcode}))
        rest = Rest.objects.get(zipcode=48201)
        serializer = restSerializer(rest)

        self.assertEqual(response.data, serializer.data)
        self.assertEqual(response.status_code, status.HTTP_200_OK)
"""

class getSingleRest(TestCase):
    def setUp(self):
        self.restBuddys = Rest.objects.create(
            restName='Buddys', zipcode = 48201, website = 'Buddys.com', phone = 3132342345, category = 0)
        self.restSyThai = Rest.objects.create(
            restName='Sy Thai', zipcode = 48201, website = 'SyThai.com', phone = 3132488736, category = 1)

    def test_get_valid_single_rest(self):
        response = client.get(reverse('restID', kwargs = {'pk' : self.restBuddys.pk}))
        
        #response = resolve('restID', pk=1)

        rest = Rest.objects.get(pk=self.restBuddys.pk)
        serializer = restSerializer(rest)



        self.assertEqual(response.data, serializer.data)
        self.assertEqual(response.status_code, status.HTTP_200_OK)