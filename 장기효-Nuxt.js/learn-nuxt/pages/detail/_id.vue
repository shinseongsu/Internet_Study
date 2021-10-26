<template>
  <div>
    <h1>상세 페이지</h1>
    <div>
      <img :src="product.imageUrl" :alt="product.name" />
      <p>name: {{ product.name }}</p>
      <p>price: {{ product.price }}</p>
    </div>
  </div>
</template>

<script>
// import axios from 'axios'
import { fetchProductById } from '@/api/index'

export default {
  async asyncData({ params }) {
    //    const id = console.log(params.id)
    const response = await fetchProductById(params.id)
    const product = response.data
    return { product }
  },
}
</script>

<style></style>
