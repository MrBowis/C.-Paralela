#include <omp.h>
#include <iostream>
#include <sys/time.h>
#include <stdio.h>
#include <math.h>
#include <conio.h>
#include <windows.h>
#include <vector>
#include <cstdlib>
#include <ctime>

#define RESET   "\033[0m"
#define RED     "\033[31m"
#define GREEN   "\033[32m"
#define BLUE    "\033[34m"

#define HIDE_CURSOR "\033[?25l"
#define SHOW_CURSOR "\033[?25h"

#define UP 72
#define DOWN 80
#define ENTER 13

double TR, TP;

void gotoxy(int x, int y);
int generarNumeroAleatorio(int min, int max);
std::vector<int> generarArreglo(int n);
int menu(const char *titulo, const char *opciones[], int n);
int binarySearchRecursive(const std::vector<int>& arr, int target, int left, int right);
void mostrarResultados(bool resultado);

int main()
{
    std::cout << HIDE_CURSOR;

    bool salir = false;
    int resultado;
    int opcion;

    int numeroElementos = 100, key = 42;
    std::vector<int> A;

    struct timeval t0, t1;
    double tiempoP = 0;

    const char *titulo = "BUSQUEDA BINARIA";
    const char *opciones[] = {"Busqueda Binaria (Secuencial)",
                              "Busqueda Binaria (Paralela)",
                              "Secuencial y Paralela",
                              "Salir"};
    int n = 4;

    while (!salir)
    {
        opcion = menu(titulo, opciones, n);
        system("cls");
        switch (opcion)
        {
        case 1:
            std::cout << "Ingrese el numero de elementos: ";
            std::cin >> numeroElementos;
            A = generarArreglo(numeroElementos);
            key = generarNumeroAleatorio(1, numeroElementos);
            gettimeofday(&t0, 0);
            binarySearchRecursive(A, key, 0, A.size() - 1);
            gettimeofday(&t1, 0);
            tiempoP = (t1.tv_sec - t0.tv_sec) + (t1.tv_usec - t0.tv_usec) / 1000000.0f;
            TR = tiempoP;
            printf("Tiempo de ejecucion (Secuencial): %1.3f ms\n", TR * 1000);
            system("pause");
            break;
        case 2:
            std::cout << "Ingrese el numero de elementos: ";
            std::cin >> numeroElementos;
            A = generarArreglo(numeroElementos);
            key = generarNumeroAleatorio(1, numeroElementos);
            gettimeofday(&t0, 0);
            resultado = binarySearchRecursive(A, key, 0, A.size() - 1);
            gettimeofday(&t1, 0);
            tiempoP = (t1.tv_sec - t0.tv_sec) + (t1.tv_usec - t0.tv_usec) / 1000000.0f;
            TP = tiempoP;
            printf("Tiempo de ejecucion (paralelo): %1.3f ms\n", TP * 1000);
            system("pause");
            break;
        case 3:
            std::cout << "Saliendo..." << std::endl;
            system("pause");
            break;
        case 4:
            salir = true;
            break;
        }
    }

    system("cls");
    std::cout << SHOW_CURSOR;
    return 0;
}

int menu(const char *titulo, const char *opciones[], int n)
{
    int opcion = 1;
    int tecla;
    bool salir = false;

    while (!salir)
    {
        system("cls");
        gotoxy(5, 3 + opcion);
        std::cout << RED << ">>" << RESET;
        gotoxy(15, 2);
        std::cout << GREEN << titulo << RESET;
        for (int i = 0; i < n; i++)
        {
            gotoxy(10, 4 + i);
            std::cout << BLUE << i + 1 << ") " << RESET << opciones[i];
        }
        do
        {
            tecla = getch();
        } while (tecla != UP && tecla != DOWN && tecla != ENTER);

        switch (tecla)
        {
        case UP: // Arriba
            opcion--;
            if (opcion < 1)
            {
                opcion = n;
            }
            break;
        case DOWN: // Abajo
            opcion++;
            if (opcion > n)
            {
                opcion = 1;
            }
            break;
        case ENTER: // Enter
            salir = true;
            break;
        }
    }
    gotoxy(0, 0);
    return opcion;
}

void gotoxy(int x, int y)
{
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

std::vector<int> generarArreglo(int n)
{
    std::vector<int> A;
    for (int i = 0; i < n; i++)
    {
        A.push_back(i + 1);
    }
    return A;
}

int generarNumeroAleatorio(int min, int max)
{
    srand(static_cast<unsigned>(time(0)));

    int num = rand() % (max - min + 1) + min;

    return num;
}

bool PBusquedaBinaria(int *A, int n, int key)
{
    int i, j, m;
    bool encontrado = false;
    int inicio = 0;
    int fin = n - 1;
    int mitad = (inicio + fin) / 2;

    #pragma omp parallel private(i, j, m) shared(encontrado, inicio, fin, mitad)
    {
        #pragma omp for
        for (i = 0; i < n; i++)
        {
            if (A[i] == key)
            {
                encontrado = true;
                #pragma omp critical
                {
                    std::cout << "Encontrado en la posicion: " << i << std::endl;
                }
            }
        }
    }
    return encontrado;
}

int binarySearchRecursive(const std::vector<int>& arr, int target, int left, int right) {
    if (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }

    return -1;
}