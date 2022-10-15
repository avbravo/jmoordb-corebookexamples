***
# Referencia de primer nivel
Es invocacion directa a la coleccion padre.
## pais-planeta 
   pais-oceano
```json
db.pais.aggregate(
[
  
   {
    $lookup:{
            from:"planeta",
            localField:"planeta.idplaneta",
            foreignField:"idplaneta",
            as:"planeta"
            }
    }
,
{ 
  $lookup:{
            from:"oceano",
            localField:"oceano.idoceano",
            foreignField:"idoceano",
            as:"oceano"
            }
  }

]
).pretty()
```
***
# Referencia de 2 Nivel
Lleva una referencia A->B->C
                     A->B->D
Donde el lookup que genera debe incluir la coleccion de segundo nivel B.C

## provincia -->pais --> planeta
                     --> oceano
Observe que los aniados deben incluir pais.pleneta.idplaneta
                                      pais.oceano.idoceano
```json
db.provincia.aggregate(
[
  
   {
    $lookup:{
            from:"pais",
            localField:"pais.idpais",
            foreignField:"idpais",
            as:"pais"
            }
    }
,
{
    $lookup:{
            from:"planeta",
            localField:"pais.planeta.idplaneta",
            foreignField:"idplaneta",
            as:"planeta"
            }
    }
,
{ 
  $lookup:{
            from:"oceano",
            localField:"pais.oceano.idoceano",
            foreignField:"idoceano",
            as:"oceano"
            }
  }

]
).pretty()
```

db.provincia.aggregate(
[
  {
  "$lookup": {
    "from": "pais", "localField": "pais.idpais", "foreignField": "idpais", "as": "pais"
  }
  },
  {
   "$lookup": {
    "from": "planeta", "localField": "pais.planeta.idplaneta", "foreignField": "idplaneta", "as": "planeta"
    }
   },
    {
    "$lookup": 
    {
      "from": "oceano", "localField": "pais.oceano.idoceano", "foreignField": "idoceano", "as": "oceano"
    }
    }

]
).pretty()






Salida

```json
{
        "_id" : ObjectId("62c0f725038c520e952b9bee"),
        "idprovincia" : "7",
        "provincia" : "Los Santos",
        "pais" : [
                {
                        "_id" : ObjectId("62bdcd44bd083f1d60193f17"),
                        "idpais" : "pa",
                        "pais" : "Panama",
                        "idioma" : {
                                "idioma" : "Español"
                        },
                        "musica" : [
                                {
                                        "idmusica" : "reggae",
                                        "musica" : "Reggae"
                                },
                                {
                                        "idmusica" : "tipico",
                                        "musica" : "Tipico"
                                }
                        ],
                        "planeta" : {
                                "idplaneta" : "tr"
                        },
                        "oceano" : [
                                {
                                        "idoceano" : "p"
                                },
                                {
                                        "idoceano" : "a"
                                }
                        ]
                }
        ],
        "planeta" : [
                {
                        "_id" : ObjectId("62bdc837bd083f1d60193f15"),
                        "idplaneta" : "tr",
                        "planeta" : "Tierra"
                }
        ],
        "oceano" : [
                {
                        "_id" : ObjectId("62bf2b8a3f94281a78781f5e"),
                        "idoceano" : "p",
                        "oceano" : "Pacífico"
                },
                {
                        "_id" : ObjectId("62bf2b9f3f94281a78781f5f"),
                        "idoceano" : "a",
                        "oceano" : "Atlántico"
                }
        ]
}
{
        "_id" : ObjectId("62c0f768038c520e952b9bef"),
        "idprovincia" : "8",
        "provincia" : "Pensilvania",
        "pais" : [
                {
                        "_id" : ObjectId("62bdcd63bd083f1d60193f18"),
                        "idpais" : "usa",
                        "pais" : "Estados Unidos",
                        "idioma" : {
                                "idioma" : "English"
                        },
                        "musica" : [
                                {
                                        "idmusica" : "rock",
                                        "musica" : "Rock"
                                },
                                {
                                        "idmusica" : "metal",
                                        "musica" : "Metal"
                                }
                        ],
                        "planeta" : {
                                "idplaneta" : "tr"
                        },
                        "oceano" : [
                                {
                                        "idoceano" : "gar"
                                },
                                {
                                        "idoceano" : "a"
                                }
                        ]
                }
        ],
        "planeta" : [
                {
                        "_id" : ObjectId("62bdc837bd083f1d60193f15"),
                        "idplaneta" : "tr",
                        "planeta" : "Tierra"
                }
        ],
        "oceano" : [
                {
                        "_id" : ObjectId("62bf2b9f3f94281a78781f5f"),
                        "idoceano" : "a",
                        "oceano" : "Atlántico"
                },
                {
                        "_id" : ObjectId("62bf2c4c3f94281a78781f61"),
                        "idoceano" : "gar",
                        "oceano" : "Oceano Glacial Artico"
                }
        ]
}
```