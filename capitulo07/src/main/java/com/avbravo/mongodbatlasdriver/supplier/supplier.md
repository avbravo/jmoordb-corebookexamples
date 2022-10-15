
# Supplier

Objetivo:
 Su funcion es procesar los documentos enviados desde un cursor, como resultado de una consulta y devolverlos como una entidad.  

Especificos:  
- Se implementa el recorrido a cada entidad para identificar si tiene @Referenced dentro de el.
- Si posee @References se deba crear dos metodos para su manejo.
- Utiliza dos metodos get() uno con Document y otro con una List<Document>
- El metodo get() con Document simple se invoca desde Repository de la misma entidad
- El metodo get() con List<Document> es invocado desde otro Supplier de nivel inferior
- Se generar parametros para cada entidad referenciada que tiene
- Se debe identificar el nivel que tiene 
- Identificar si es de tipo simple o compuesto
- Cuando es de nivel 2 o superior se debe obtener un List<Document> por cada entidad referenciada de los demàs niveles
- Por ejemplo
- Se debe usar el enum LookupLevel para indicar el nivel que sera pasado a los LookupSupplier
- Cada LookupSupplier debe tener LookupSupplierLevel levelLocal= LookupSupplierLevel.ZERO;
  ese valor se debe comparar con el que le esta llegando.
- Para el segundo get() las reglas son:
  1. Se debe pasar un List<Document> correspondientes a la misma entidad del supplier
  2. Se deben pasar los List<Document> correspondientes a cada entidad @Referenced de todas las entidades relacioneadas con la entidad
-- public static Provincia get(Supplier<? extends Provincia> s, List<Document> documentProvinciaList, List<Document> documentPaisList, List<Document> documentPlanetaList, List<Document> documentOceanoList) {
}

```java
  Provincia {
    Pais{
         Planeta  planeta;
         List<Ocenano> oceano;
        }

  }
```
El supplier de Pais debe generar en el supplier el metodo get con una List<Document> para
pais, planeta, oceano ya que la consulta de provincia los generaria con un List<Document>  
Se debe verificar si es simple o son List.
```java
 public static Pais get(Supplier<? extends Pais> s, List<Document> documentList, List<Document> documentPlanetaList, List<Document> documentOceanoList) {
}
```
  por esta razon la entidad es pasada como una lista de documentos.
- Se debe deteminar en nivel de la relacion  
-- Nivel 1: 
-- Nivel 2:
-- Nivel 3:

-- Metodo get( 


## Analisis de niveles
Recuerde que el segundo metodo get() es invocado desde otro Supplier.

### Nivel: 0 (Entidad Final)
```
 /**
             * Entidad: Oceano
             * Oceano{
             *    // No tiene embedded ni @Referenced
             * }
             *
             * Nivel de Trabajo : 0
             * 
             * Esquema de Niveles:
             * | Nivel 0|
             *   Oceano
             * 
             */ 
```
Metodos get(), trabajan directo
```java
public static Oceano get(Supplier<? extends Oceano> s, Document document) {
}
```
Como es de nivel 0 solo tendra un parametro de tipo List<Document>
```java
public static Oceano get(Supplier<? extends Oceano> s, List<Document> documentList) {
}
```

## Nivel 1: (Tiene referencias)
```
            /**
             * Entidad:
             * Pais{
             *
             *     @Embedded Idioma idioma;
             *     @Embedded List<Musica>;
             *     @Referenced Planeta planeta;
             *     @Referenced List<Oceano>; 
             * }
             * 
             * Nivel de Trabajo : 1
             * 
             * Esquema de Niveles:
             * |Nivel 1  |  Nivel 0
             * Pais    -->  @E(Idioma)
             * Pais    -->  @E(List<Musica>
             * Pais    -->  @R(Planeta)
             * Pais    -->  @R(List<Planeta>
             * 
             */
```

```java
 public static Pais get(Supplier<? extends Pais> s, Document document) {
}

```
Como es de nivel uno se debe generar un List<Document> para cada @Referenced de nivel 0
```java
public static Pais get(Supplier<? extends Pais> s, List<Document> documentPaisList, List<Document> documentPlanetaList, List<Document> documentOceanoList) {
}
```

***
## Nivel 2 (Tiene referecia a una entidad que tiene referencia)
Debe invocar al Supplier de la entidad referenciada mediante el metodo get()
pasandole List<Document> de cada entidad referenciada.

Restricciones:
   - Nivel 2 no permite @Referenced List<> a una entidad de nivel 1
     Por lo tanto @Referenced List<Pais> no sera valido
   - Nivel 2 si permite @Referenced List<> a una entidad de nivel 0
     Por lo tanto @Referenced Pais es valido  
     Tambien es valido @Referenced List<Planeta> ya que planeta es una entidad de nivel 0



```
             * Esto aplica para nivel 2 donde hay que conocer los padres que
             * tiene Se debe conocer de la entidad de siguente nivel Pais cuales
             * son sus referencias para pasarlos como List<Document>
             * Provincia{
             *
             *       @Referenced Pais {
             *                        @Referenced Planeta planeta;
             *                        @Referenced List<Oceano> oceano;
             *                        @Embedded Idioma idioma;
             *                        @Embedded List<Musica> musica; 
             *                        }
             * }
             * 
             * Se puede observar que hay referencias de nivel 2:
             * Nivel 2           Nivel 1    Nivel 0
             *      Provincia --> Pais   -->@R Planeta
             *      Provincia --> Pais   -->@R (List<Oceano>
             *      Provincia --> Pais   -->@E (Idioma)
             *      Provincia --> Pais   -->@E (List<Music>
             *
             */
```
```java
public static Provincia get(Supplier<? extends Provincia> s, Document document) {
 // Debe obtener cada entidad referencia de nivel 1, y 0 como un list
      List<Document> documentPaisList = (List<Document>) document.get("pais");
      List<Document> documentPlanetaList = (List<Document>) document.get("planeta");
      List<Document> docOceanoList = (List<Document>) document.get("oceano");
   
     provincia.setPais(PaisSupplier.get(Pais::new, documentPaisList, documentPlanetaList, docOceanoList));

}


```