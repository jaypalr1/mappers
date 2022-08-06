# Field Mappers

1. [JMapper](#JMapper)
2. [MapStruct](#MapStruct)
3. [Orika](#Orika)
4. [ModelMapper](#ModelMapper)
5. [Dozer](#DozerMapper)

[Various Mappers Performance](https://www.baeldung.com/java-performance-mapping-frameworks)

## JMapper:

### Reference Documentation

* [Baeldung](https://www.baeldung.com/jmapper)

### Identifications

* Mapper is the mapping framework that aims to provide an easy-to-use, high-performance mapping
  between Java Beans.
* Source and destination fields can be different for mapping.
* There are 3 ways to map the fields
    1. API
    2. Annotations
    3. XML
* add jar <b> <i>com.googlecode.jmapper-framework:jmapper-core:version </i> </b>
* In annotation mapping we've to use @JMap annotation on the target field to map it from source
  field.

## MapStruct:

### Reference Documentation

* [Baeldung](https://www.baeldung.com/mapstruct)
* [Spring Guru](https://springframework.guru/using-mapstruct-with-project-lombok/)
* [StackOverFlow](https://stackoverflow.com/questions/47676369/mapstruct-and-lombok-not-working-together)

### Identifications

* Use for mapping fields from source to target.
* Need to add jar  <b> <i> org.mapstruct:mapstruct:version </i> </b> and appropriate mapping fields.
  Voilà we're good to go.
* However, it doesn't work well with Lombok. To make it work with lombok we've to add plugin and
  make necessary changes to the plugin. Like adding lombok annotation path in the map-struct plugin.
* Maven only uses the MapStruct processor and not the Lombok one. The annotationProcessorPaths tells
  maven which processors it should use (Refer pom plugins).
* Let's look at the changes that we need to do:
    * First we need to create an interface annotate it with <b> <i> @Mapper </i> </b> annotation
    * Now we can start mapping by creating un-implemented methods in an interface and annotating
      various fields with <b> <i> @Mapping </i> </b> annotation.
    * e.x:

          @Mapper 
          public interface SourceToDestinationMapper {
            @Mapping(target = "targetField", source = "sourceField")
            Destination toDestination(Origin origin);
          }
* We can mix and match the fields to map i.e., we can specify the field names directly or by using
  object name and then field name

      source = "fieldName" or source = "origin.fieldName"

* The problem with this interface is that it won't be available for dependency injection. To make it
  available we've specified <b> <i> compilerArgs </i> </b> in plugin. Which makes sure that the
  mapper becomes available for dependency injection.
* If we're writing test or standalone app we can get the instance of Mapper by using-

      SourceToDestinationMapper mapper = Mappers.getMapper(SourceToDestinationMapper.class);
* We can also map the fields by using <b> <i> @AfterMapping </i> </b> annotation on a default method
  in an interface. The code is executed right after mapping is completed.

## Orika:

### Reference Documentation

### Identifications

## ModelMapper:

### Reference Documentation

### Identifications

## DozerMapper:

### Reference Documentation

* [Baeldung](https://www.baeldung.com/dozer)

### Identifications

* Dozer is a Java Bean to Java Bean mapper that recursively copies data from one object to another,
  attribute by attribute.
* The library not only supports mapping between attribute names of Java Beans, but also
  automatically converts between types – if they're different.
* Need to add jar <b> <i> net.sf.dozer:dozer:version </i> </b>.
* Create a bean of type <b> <i> DozerBeanMapper </i> </b> and use it's <b> <i> map() </i> </b> to
  convert the fields from source to destination.
* <b> IMP NOTE: Field names have to be same in source and destination object. </b>

      @Autowired
      DozerBeanMapper dozerBeanMapper;

      void mapFromSourceToDestination() {
        Destination dest = dozerBeanMapper.map(sourceObject, Destination.class);
      }
