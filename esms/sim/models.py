from django.db import models

# models for Student Information Managment (SIM) System

GENDER_CHOICES = (
	('M', 'Male'),
	('F', 'Female'),
)

CASTE_CHOICES = (
	('OC', 'OC'),
	('BC', 'BC'),
	('ST', 'ST'),
	('SC', 'SC'),
	('GEN', 'GEN'),
)

RELATIONSHIP_CHOICES = (
	('mother', 'Mother'),
	('father', 'Father'),
)


class Address(models.Model):
	address1 = models.CharField(max_length=50)
	address2 = models.CharField(max_length=50, blank=True)
	city = models.CharField(max_length=20)
	state = models.CharField(max_length=20)
	country = models.CharField(max_length=20)
	email = models.EmailField(max_length=75)
	phone1 = models.IntegerField('primary phone')

	class Meta:
		abstract = True


class College(Address):
	name = models.CharField('name of the college', max_length=100)
	short_name = models.CharField('college short name', max_length=5, blank=True)
	phone2 = models.IntegerField('secondary phone', blank=True)

	def __unicode__(self):
		return self.name

class EmployeeInfo(models.Model):
	first_name = models.CharField(max_length=50)
	last_name = models.CharField(max_length=50)
	middle_name = models.CharField(max_length=50, blank=True)
	highest_qalification = models.CharField(max_length=100)
	designation = models.CharField(max_length=100)
	role = models.CharField(max_length=50, blank=True)

	def __unicode__(self):
		return self.name

	def _get_full_name(self):
		return '%s %s %s' % (self.first_name, self.middle_name, self.last_name)

	full_name = property(_get_full_name)

class StudentInfo(Address):
	first_name = models.CharField(max_length=50)
	last_name = models.CharField(max_length=50)
	middle_name = models.CharField(max_length=50, blank=True)
	sex = models.CharField(max_length=1, choices=GENDER_CHOICES)
	nationality = models.CharField(max_length=30)
	caste = models.CharField(max_length=4, choices=CASTE_CHOICES)
	dob = models.DateField('date of birth')
	doj = models.DateField('date of joining')
	dol = models.DateField('date of leaving', blank=True)
	last_updated = models.DateField()
	last_updated_userid = models.IntegerField()

	def __unicode__(self):
		return self.name

class ParentInfo(models.Model):
	student_id = models.ForeignKey('StudentInfo', verbose_name='student id')
	first_name = models.CharField(max_length=50)
	last_name = models.CharField(max_length=50)
	middle_name = models.CharField(max_length=50, blank=True)
	email = models.EmailField(max_length=75, blank=True)
	phone1 = models.IntegerField('primary phone')
	phone2 = models.IntegerField('secondary phone', blank=True)
	sex = models.CharField(max_length=1, choices=GENDER_CHOICES)
	releationship = models.CharField(max_length=10, choices=RELATIONSHIP_CHOICES)	

	def __unicode__(self):
		return self.name
