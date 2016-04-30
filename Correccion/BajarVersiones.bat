set repositorio=URL REPOSITORIO REMOTOR EJ:git@bitbucket.org:...
set binFolder=bin
set IDGRUPO=IDENTIFICACION DEL GRUPO NIA1_NIA2

git clone %repositorio% facturacionV1
cd facturacionV1
git checkout -b facturacionV1 Version1
cd ..

git clone %repositorio% facturacionV1.1
cd facturacionV1.1
git checkout -b facturacionV2 Version1.1
cd ..

git clone %repositorio% facturacionV2
cd facturacionV2
git checkout -b facturacionV2 Version2
cd ..

git clone %repositorio% facturacionV3
cd facturacionV3
git checkout -b facturacionV3 Version3
cd ..

git clone %repositorio% facturacionV3.1
cd facturacionV3.1
git checkout -b facturacionV3.1 Version3.1
cd ..

git clone %repositorio% facturacionV4
cd facturacionV4
git checkout -b facturacionV4 Version4
cd ..

git clone %repositorio% facturacionV4.1
cd facturacionV4.1
git checkout -b facturacionV4.1 Version4.1
cd ..

git clone %repositorio% facturacionV4.2
cd facturacionV4.2
git checkout -b facturacionV4.2 Version4.2
cd ..

