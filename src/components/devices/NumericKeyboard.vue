<template>
  <div class="input">
    <label>Amount: </label>
    <NumericInput  v-model="amount" />
  </div>
</template>

<script>
  import { NumericInput } from 'numeric-keyboard'
  export default {
    components: {
      NumericInput
    },
    data() {
      return {
       amount: null
      }
    }
  }
</script>