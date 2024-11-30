PostalCodeService
PostalCodeService, girilen posta kodunun hangi şehre ait olduğunu belirten bir mikro servis ve REST API'dir.
Bu proje, posta kodlarına ve şehir isimlerine dayalı veri sorgulama işlemlerini veritabanı ve dış API (Geonames API) kullanarak yönetir.

Proje şu şekilde çalışmaktadır:

1. Posta Kodu Sorgulama: Kullanıcı tarafından girilen posta kodu, öncelikle veritabanında sorgulanır.
   Eğer veri mevcutsa, sistem bu veriyi veritabanından getirir. Veritabanında bulunmayan bir posta kodu için ise,
   Geonames API'den veri çekilir, veritabanına kaydedilir ve ardından client'a döndürülür.

2. Şehir Adına Göre Veri Sorgulama: Kullanıcı tarafından girilen bir şehir ismi ile, eğer o şehre ait veriler veritabanında mevcutsa, ilgili posta kodları döndürülür.
   Veritabanında veri yoksa, ResponseEntity boş bir liste olarak döner.

Katmanlar
1. Repository Katmanı
   PostalCode: Bu katman, projenin veri işlemleriyle ilgilenir. Veritabanı ile etkileşime girerek, veri oluşturma, okuma, güncelleme ve silme işlemlerini gerçekleştirir.
   Veritabanı işlemleri için kullanılan repository katmanıdır.

2. GeonamesPostalCodeServiceLib Katmanı
   Bu katman, posta koduna ilişkin verileri dış bir API (Geonames API) üzerinden çeker ve bu verileri döndüren bir servisi içerir.
   API aracılığıyla alınan veriler, veritabanına kaydedilmeden önce işlenir.

4. Dataservice Katmanı
   PostalCodeDataService: Bu katman, client ile repository arasında bir köprü işlevi görür.
   Client tarafından yapılan veri talepleri, önce bu katman üzerinden işlenir.
   Eğer talep edilen posta kodu veritabanında mevcutsa, veritabanından çekilir.
   Eğer veri veritabanında yoksa, GeonamesPostalCodeServiceLib kullanılarak Geonames API'den veri alınır, veritabanına kaydedilir ve ardından client'a gönderilir.
   Ayrıca, şehir adıyla yapılan veri sorgulamalarında da benzer bir süreç takip edilir. Şehre ait veriler veritabanında mevcutsa, ilgili posta kodları döndürülür;
   Yoksa boş bir liste döner.
4. Client Katmanı
   PostalCodeClient: Bu katman, dataservice katmanı ile etkileşime giren ve API'ye gelen GET isteklerini yöneten controller katmanıdır.
   Client katmanı, veri taleplerinin karşılanmasında önemli bir rol oynar ve API'nin dış dünyaya açılan kapısını oluşturur.
