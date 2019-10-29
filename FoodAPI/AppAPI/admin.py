from django.contrib import admin
from .models import Rest
from .models import Item


# Register your models here.
admin.site.register(Rest)
admin.site.register(Item)